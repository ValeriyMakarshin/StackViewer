package com.hodzi.stackviewer.utils

import com.hodzi.stackviewer.model.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("/2.2/questions")
    fun getQuestions(
        @Query("order") order: String = Orders.DESC.value,
        @Query("site") site: String = Sites.STACKOVERFLOW.value,
        @Query("sort") sort: String = Sorts.ACTIVITY.value,
        @Query("filter") filter: String = Filters.WITHBODY.value
    ): Observable<Block<Question>>

    @GET("/2.2/questions/{questionId}/answers")
    fun getAnswers(
        @Path("questionId") questionId : Int,
        @Query("order") order: String = Orders.DESC.value,
        @Query("site") site: String = Sites.STACKOVERFLOW.value,
        @Query("sort") sort: String = Sorts.ACTIVITY.value,
        @Query("filter") filter: String = Filters.WITHBODY.value
    ): Observable<Block<Answer>>

    @GET("/2.2/tags")
    fun getTags(
        @Query("order") order: String = Orders.DESC.value,
        @Query("site") site: String = Sites.STACKOVERFLOW.value,
        @Query("sort") sort: String = Sorts.POPULAR.value,
        @Query("filter") filter: String = Filters.WITHBODY.value
    ): Observable<Block<Tag>>

    @GET("/2.2/users")
    fun getUsers(
        @Query("order") order: String = Orders.DESC.value,
        @Query("site") site: String = Sites.STACKOVERFLOW.value,
        @Query("filter") filter: String = Filters.WITHBODY.value,
        @Query("sort") sort: String = Sorts.REPUTATION.value
    ): Observable<Block<User>>
}
