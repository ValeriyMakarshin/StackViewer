package com.hodzi.stackviewer.di

import com.stackviewer.medium.utils.Api
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
public class NetModule(val  baseUrl: String) {

    private val baseUrl1 = "12345"

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
//                .addNetworkInterceptor(NetUtils.getInterceptor())
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()
    }
}