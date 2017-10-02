package com.stackviewer.medium.utils

import retrofit2.http.GET
import rx.Observable


interface Api{
    @GET("test")
    fun signIn(): Observable<String>
}
