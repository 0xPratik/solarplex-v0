package com.example.solarplexv0.network

import com.example.solarplexv0.model.Forum
import com.example.solarplexv0.model.Tag
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Singleton


@Singleton
interface SolarplexAPI {

//    @GET("action/pending/tmpdid-{userInput}:0096")
//    fun getData(@Path("userInput") userInput: String?): Call<YourResponseType?>?

    @GET(value = "entities/forum/yjtu_Y1CgN98OJOF")
    suspend fun getForum() : Forum

    @GET(value = "action/pending/tmpdid-{userAddress}:0096")
    suspend fun getPendingActions(
        @Path("userAddress") userAddress: String?
    )

    @GET(value = "entities/tags")
    suspend fun getAllTags() : Tag

    @GET(value = "entities/forum/yjtu_Y1CgN98OJOF/topics")
    suspend fun getAllTopics()


}