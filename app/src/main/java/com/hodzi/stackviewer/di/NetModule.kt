package com.hodzi.stackviewer.di

import com.hodzi.stackviewer.NetUtils
import com.stackviewer.medium.utils.Api
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetModule {
    private val baseUrl = "https://api.stackexchange.com/2.2/"

    @Provides
    @Singleton
    fun provideApi(httpClient: OkHttpClient): Api {
        return Retrofit.Builder()
                .client(httpClient)
                .baseUrl(baseUrl)
                .build()
                .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .addNetworkInterceptor(NetUtils.interceptor)
                .build()
    }
}