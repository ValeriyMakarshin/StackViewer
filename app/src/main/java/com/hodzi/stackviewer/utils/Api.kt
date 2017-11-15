package com.hodzi.stackviewer.utils

import com.hodzi.stackviewer.Const
import com.hodzi.stackviewer.model.*
import io.reactivex.Observable
import retrofit2.http.*

interface Api {
    @GET("/2.2/questions")
    fun getQuestions(
        @Query("order") order: String = Orders.DESC.value,
        @Query("site") site: String = Sites.RU_STACKOVERFLOW.value,
        @Query("sort") sort: String = Sorts.ACTIVITY.value,
        @Query("filter") filter: String = Filters.WITHBODY.value
    ): Observable<Block<Question>>

    @GET("/2.2/questions/{questionId}/answers")
    fun getAnswers(
        @Path("questionId") questionId : Int,
        @Query("order") order: String = Orders.DESC.value,
        @Query("site") site: String = Sites.RU_STACKOVERFLOW.value,
        @Query("sort") sort: String = Sorts.ACTIVITY.value,
        @Query("filter") filter: String = Filters.WITHBODY.value
    ): Observable<Block<Answer>>

    @FormUrlEncoded
    @POST("/2.2/questions/{questionId}/upvote")
    fun questionUpVote(
        @Path("questionId") questionId : Int,
        @Field("access_token") token: String,
        @Field("preview") preview: Boolean = true,
        @Field("filter") filter: String = Filters.DEFAULT.value,
        @Field("site") site: String = Sites.RU_STACKOVERFLOW.value,
        @Field("key") key: String = Const.API_KEY
    ): Observable<Question>

    @FormUrlEncoded
    @POST("/2.2/questions/{questionId}/downvote")
    fun questionDownVote(
        @Path("questionId") questionId : Int,
        @Field("access_token") token: String,
        @Field("preview") preview: Boolean = true,
        @Field("filter") filter: String = Filters.DEFAULT.value,
        @Field("site") site: String = Sites.RU_STACKOVERFLOW.value,
        @Field("key") key: String = Const.API_KEY
    ): Observable<Question>

    @FormUrlEncoded
    @POST("/2.2/answers/{answerId}/upvote")
    fun answersUpVote(
        @Path("answerId") answerId : Int,
        @Field("access_token") token: String,
        @Field("preview") preview: Boolean = true,
        @Field("filter") filter: String = Filters.DEFAULT.value,
        @Field("site") site: String = Sites.RU_STACKOVERFLOW.value,
        @Field("key") key: String = Const.API_KEY
    ): Observable<Answer>

    @FormUrlEncoded
    @POST("/2.2/answers/{answerId}/downvote")
    fun answersDownVote(
        @Path("answerId") answerId : Int,
        @Field("access_token") token: String,
        @Field("preview") preview: Boolean = true,
        @Field("filter") filter: String = Filters.DEFAULT.value,
        @Field("site") site: String = Sites.RU_STACKOVERFLOW.value,
        @Field("key") key: String = Const.API_KEY
    ): Observable<Answer>

    @GET("/2.2/tags")
    fun getTags(
        @Query("order") order: String = Orders.DESC.value,
        @Query("site") site: String = Sites.RU_STACKOVERFLOW.value,
        @Query("sort") sort: String = Sorts.POPULAR.value,
        @Query("filter") filter: String = Filters.WITHBODY.value
    ): Observable<Block<Tag>>

    @GET("/2.2/users")
    fun getUsers(
        @Query("order") order: String = Orders.DESC.value,
        @Query("site") site: String = Sites.RU_STACKOVERFLOW.value,
        @Query("filter") filter: String = Filters.WITHBODY.value,
        @Query("sort") sort: String = Sorts.REPUTATION.value
    ): Observable<Block<User>>
}
