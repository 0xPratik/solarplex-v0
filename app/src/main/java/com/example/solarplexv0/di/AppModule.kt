package com.example.solarplexv0.di

import com.example.kdispatchsdk.Endpoints
import com.example.kdispatchsdk.Solarplex
import com.example.kdispatchsdk.SolarplexApi
import com.example.solarplexv0.utils.Constants
import com.solana.mobilewalletadapter.clientlib.MobileWalletAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesSolarplexApi() : SolarplexApi {
        return Solarplex(Endpoints.Devnet).getSolarplexApi()
    }

    @Provides
    fun providesMobileWalletAdapter(): MobileWalletAdapter {
        return MobileWalletAdapter()
    }
}