package com.example.solarplexv0.di

import com.example.solarplexv0.network.SolarplexAPI
import com.example.solarplexv0.utils.Constants
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
    fun providesSolarplexApi() : SolarplexAPI {
        return Retrofit.
        Builder().
        baseUrl(Constants.BASE_URL).
        addConverterFactory(GsonConverterFactory.create()).
        build().
        create(SolarplexAPI::class.java)
    }
}