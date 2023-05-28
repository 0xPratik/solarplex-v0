package com.example.solarplexv0.network

import com.example.solarplexv0.model.Forum
import retrofit2.http.GET
import javax.inject.Singleton


@Singleton
interface SolarplexAPI {

    @GET(value = "entities/forum/yjtu_Y1CgN98OJOF")
    suspend fun getForum() : Forum
}