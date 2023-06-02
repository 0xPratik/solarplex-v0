package com.example.kdispatchsdk

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

enum class Endpoints(val url : String) {
    Devnet("https://dev.api.solarplex.xyz/"),
    Mainnet("https://prod.api.solarplex.xyz/")
}

open class Solarplex(private val baseurl: Endpoints) {

    fun getSolarplexApi() : SolarplexApi {
        return Retrofit.
        Builder().
        baseUrl(baseurl.url).
        addConverterFactory(GsonConverterFactory.create()).
        build().create(SolarplexApi::class.java)
    }

}