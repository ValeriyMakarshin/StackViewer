package com.hodzi.stackviewer

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response

class MockInterceptor(context: Context,
                      private val requestHandler: RequestHandler = RequestHandler(context))
    : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response? {
        val request = chain?.request()!!
        val path: String = chain.request()?.url()?.encodedPath()!!
        return if (requestHandler.intercept(path)) {
            requestHandler.proceed(request, path)
        } else {
            chain.proceed(request)
        }
    }
}


