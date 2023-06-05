package com.example.kdispatchsdk

import com.example.kdispatchsdk.model.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


data class ActionRequest(
    val action: RequestBody
)

data class RequestBody(
    val creatorId: String,
    val wallet: String,
    val chainId: Int,
    val hash: String,
    val action: Action
)

enum class ActionType(val value: Int) {
    POST(100),
    TOPIC(140),
    VOTE(160)
}

enum class CrudType(val value: Int) {
    POST(1),
    PUT(2),
    DELETE(3)
}
data class Action(
    val crud: Int,
    val type: Int,
    val parentId: String,
    val params: Params
)

data class Params(
    val title: String,
    val body: String,
    val value: Int
)


 interface SolarplexApi {

    @GET(value = "entities/forum/{forumId}")
    suspend fun getForum(
        @Path("forumId") forumId : String = "yjtu_Y1CgN98OJOF"
    ) : Forum

    @GET(value = "action/pending/tmpdid-{userAddress}:0096")
    suspend fun getPendingActions(
        @Path("userAddress") userAddress: String?
    ) : PostBox

    @GET(value = "entities/tags")
    suspend fun getAllTags() : Tag

    @GET(value = "entities/forum/{forumId}/topics")
    suspend fun getAllTopics(
        @Path("forumId") forumId : String = "yjtu_Y1CgN98OJOF"
    ): Topic

    @POST(value = "action")
    suspend fun performAction(
        @Body request: ActionRequest
    ): ActionReturnType

}