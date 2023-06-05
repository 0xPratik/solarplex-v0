package com.example.kdispatchsdk

import com.example.kdispatchsdk.model.*
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

enum class DispatchEndpoints(val url : String) {
    Devnet("https://dev.api.solarplex.xyz/"),
    Mainnet("https://prod.api.solarplex.xyz/")
}

open class Solarplex(private val baseurl: DispatchEndpoints) {


    private val apiService : SolarplexApi = Retrofit.Builder()
        .baseUrl(baseurl.url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(SolarplexApi::class.java)

    suspend fun getForum(forumId: String = "yjtu_Y1CgN98OJOF") : Forum {
        return apiService.getForum(forumId = forumId)
    }

    suspend fun getPendingActions(userAddress: String): PostBox {
        return apiService.getPendingActions(userAddress = userAddress)
    }

    suspend fun getTags(): Tag {
        return apiService.getAllTags()
    }

    suspend fun getAllTopics(forumId: String = "yjtu_Y1CgN98OJOF") : Topic {
        return apiService.getAllTopics(forumId)
    }
    // TODO Can make the chainId into an Enum or sealed class
    suspend fun createAPost(
        userAddress: String,
        parentId : String,
        title: String,
        body: String,
        chainId : Int = 20,
    ): ActionReturnType {

        // I am not sure if the value should be kept 1 over here or 0 or it does not matters cause the backend does not processes it
        val action = Action(
            crud = CrudType.POST.value,
            type = ActionType.POST.value,
            parentId = parentId,
            params = Params(
                title = title,
                body = body,
                value = 1
            )
        )

        val gson = Gson()
        val hashedAction = calculateSHA256(gson.toJson(action))

        return apiService.performAction(
            ActionRequest(
                RequestBody(
                    creatorId = getCreatorId(userAddress),
                    wallet = userAddress,
                    chainId = chainId,
                    action = action,
                    hash = hashedAction
                )
            )
        )
    }


    // It seams like even if the post is in pending state it can be changed is this ok to do
    suspend fun updateAPost(userAddress: String,
                            crudEntityId: String,
                            title: String,
                            body: String,
                            chainId: Int = 20) : ActionReturnType
    {

        val action = Action(
            crud = CrudType.PUT.value,
            type = ActionType.POST.value,
            parentId = crudEntityId,
            params = Params(
                title = title,
                body = body,
                value = 1
            )
        )

        val gson = Gson()
        val hashedAction = calculateSHA256(gson.toJson(action))

        println("HashedAction" + hashedAction)

       return apiService.performAction(
            ActionRequest(
                RequestBody(
                    creatorId = getCreatorId(userAddress),
                    wallet = userAddress,
                    chainId = chainId,
                    action = action,
                    hash = hashedAction
                )
            )
        )
    }


    // not sure if the delete action takes the actionDeleteKey from the meta field in response

    suspend fun deleteAPost(userAddress: String,
                            crudEntityId: String,
                            chainId: Int = 20,
                           ) : ActionReturnType {


        val action = Action(
            crud = CrudType.DELETE.value,
            type = ActionType.POST.value,
            parentId = crudEntityId,
            params = Params(
                title = "",
                body = "",
                value = 1
            )
        )

        val gson = Gson()
        val hashedAction = calculateSHA256(gson.toJson(action))


        return apiService.performAction(
            ActionRequest(
                RequestBody(
                    creatorId = getCreatorId(userAddress),
                    wallet = userAddress,
                    chainId = chainId,
                    action =  action,
                    hash = hashedAction
                )
            )
        )


    }

}