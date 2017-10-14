package com.stackviewer.medium.utils

import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.model.Tag
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {
    @GET("/2.2/questions?order=desc&sort=activity&site=stackoverflow")
    fun getQuestions(): Observable<Block<Question>>

    @GET("/2.2/tags?site=stackoverflow&order=desc&sort=popular&filter=default")
    fun getTags(): Observable<Block<Tag>>
}
