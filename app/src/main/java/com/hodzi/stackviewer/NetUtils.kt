package com.hodzi.stackviewer

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor

object NetUtils {

    val interceptor: Interceptor
        get() = StethoInterceptor()
}
