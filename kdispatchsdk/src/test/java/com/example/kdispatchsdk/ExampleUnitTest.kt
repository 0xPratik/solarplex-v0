package com.example.kdispatchsdk

import com.solana.Solana
import com.solana.api.sendRawTransaction
import com.solana.core.HotAccount
import com.solana.core.Transaction
import com.solana.networking.HttpNetworkingRouter
import com.solana.networking.RPCEndpoint
import kotlinx.coroutines.runBlocking
import org.bitcoinj.core.Base58
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    val userAddress = "9JyYNZ5GGcuZ28HpKdQDjBip5DBdvwEaBwdyz1zZvN51"
    var entityId : String = ""
    @Test
    fun doesReturnForum() {
        runBlocking {
            val data = Solarplex(DispatchEndpoints.Devnet).getForum()
            println("Forum Data" + data)
        }
    }

    @Test
    fun doesReturnTags() {
        runBlocking {
            val tags = Solarplex(DispatchEndpoints.Devnet).getTags()
            println("TAGS" + tags)
        }
    }


    // Gives TimeOut Error
    @Test
    fun doesGetAlltheTopics() {
        runBlocking {
            val topics = Solarplex(DispatchEndpoints.Devnet).getAllTopics()
            println("TOPICS" +topics)
        }
    }


    @Test
    fun doesCreatesAPost() {
        runBlocking {
            val createPostRes = Solarplex(DispatchEndpoints.Devnet).createAPost(
                userAddress = userAddress,
                parentId = "Created from Kotlin test",
                title = "Created from Kotlin Test",
                body = "Let's see if this works or not"
            )

            println("CreatePostRes" + createPostRes);

            val secretkey = Base58.decode("3wtbsp28uewQhRmHY6Grv8e11JypXVxeVwM1GDCjCSUoYBCCV1g8uNbDunNiajgribcQETHJ7FvR3SQSZQtuPBo6")

            val testWallet = HotAccount(secretkey);

            assertEquals("PitRBc6thx3xkULgMbEiBe1qcCHshcTiMciwrj5wMAY",testWallet.publicKey.toString())

            val endPoint = RPCEndpoint.devnetSolana
            val network = HttpNetworkingRouter(endPoint)
            val solana = Solana(network)
            val txData = createPostRes[0].signedTxn.data
            val intArray: IntArray = txData.toIntArray()
            val txByteArray = intArray.map { it.toByte() }.toByteArray()
            val tx  = Transaction.from(txByteArray)
            println("Transaction " + tx)
            val signedTx = testWallet.sign(tx.serializeMessage())




        }
    }

    @Test
    fun doesUpdateAPost() {
        runBlocking {
            val updatePostRes = Solarplex(DispatchEndpoints.Devnet).updateAPost(
                userAddress = userAddress,
                crudEntityId = "6XKrx6HSTdULGTkN",
                title= "Updated the post created from the Test",
                body = "Updated the body of the post created from the test"
            )

            println("Updated Post Res :- " + updatePostRes);
        }
    }

    @Test
    fun doesDeleteAPost() {
            runBlocking {

                val deletePostRes = Solarplex(DispatchEndpoints.Devnet).deleteAPost(
                    userAddress = userAddress,
                    crudEntityId = "6XKrx6HSTdULGTkN",
                )

                println("DeletePost Res " + deletePostRes)


            }




    }

}