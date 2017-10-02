package com.hodzi.stackviewer

import android.content.Context

import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor

import okhttp3.Interceptor

object NetUtils {

    val interceptor: Interceptor
        get() = StethoInterceptor()

    fun init(context: Context) {
        Stetho.initializeWithDefaults(context)
    }

}
