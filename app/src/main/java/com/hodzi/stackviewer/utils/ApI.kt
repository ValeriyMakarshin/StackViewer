package com.stackviewer.medium.utils

import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.model.Question
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {
    @GET("/2.2/questions?order=desc&sort=activity&site=stackoverflow")
    fun getQuestions(): Observable<Block<Question>>
}
