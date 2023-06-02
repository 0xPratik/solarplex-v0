package com.example.kdispatchsdk

import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun doesReturnForum() {
        runBlocking {
            val data = Solarplex(Endpoints.Devnet).getSolarplexApi().getForum()
            println(data)
        }
    }

    @Test
    fun doesReturnTags() {
        runBlocking {
            val tags = Solarplex(Endpoints.Devnet).getSolarplexApi().getAllTags()
            println(tags)
        }
    }

    @Test
    fun doesGetAlltheTopics() {
        runBlocking {
            val topics = Solarplex(Endpoints.Devnet).getSolarplexApi().getAllTopics()
            println(topics)
        }
    }

    @Test
    fun doesCreatesAPost() {
        runBlocking {
//            val res = Solarplex(Endpoints.Devnet).getSolarplexApi().performAction(
//
//            )
        }
    }

}