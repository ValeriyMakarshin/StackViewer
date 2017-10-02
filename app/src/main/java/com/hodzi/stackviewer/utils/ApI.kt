package com.stackviewer.medium.utils

import retrofit2.http.GET
import rx.Observable


interface Api{
    @GET("/2.2/questions?order=desc&sort=activity&site=stackoverflow")
    fun getQuestions(): Observable<String>
}
