package com.hodzi.stackviewer.di

import android.content.Context
import com.hodzi.stackviewer.NetUtils
import com.hodzi.stackviewer.utils.Api
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(val context: Context) {
    private val baseUrl = "https://api.stackexchange.com/"

    @Provides
    @Singleton
    fun provideApi(httpClient: OkHttpClient): Api {
        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
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
