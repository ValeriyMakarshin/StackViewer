package com.hodzi.stackviewer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("tags") @Expose val tags: List<String>,
    @SerializedName("owner") @Expose val owner: Owner,
    @SerializedName("is_answered") @Expose val isAnswered: Boolean,
    @SerializedName("view_count") @Expose val viewCount: Int,
    @SerializedName("favorite_count") @Expose val favoriteCount: Int,
    @SerializedName("down_vote_count") @Expose val downVoteCount: Int,
    @SerializedName("up_vote_count") @Expose val upVoteCount: Int,
    @SerializedName("answer_count") @Expose val answerCount: Int,
    @SerializedName("score") @Expose val score: Int,
    @SerializedName("last_activity_date") @Expose val lastActivityDate: Int,
    @SerializedName("creation_date") @Expose val creationDate: Int,
    @SerializedName("last_edit_date") @Expose val lastEditDate: Int,
    @SerializedName("question_id") @Expose val questionId: Int,
    @SerializedName("link") @Expose val link: String,
    @SerializedName("title") @Expose val title: String,
    @SerializedName("body") @Expose val body: String) : Data


//{
//    "tags": [
//    "windows",
//    "c#",
//    ".net"
//    ],
//    "owner": {
//    "reputation": 9001,
//    "user_id": 1,
//    "user_type": "registered",
//    "accept_rate": 55,
//    "profile_image": "https://www.gravatar.com/avatar/a007be5a61f6aa8f3e85ae2fc18dd66e?d=identicon&r=PG",
//    "display_name": "Example User",
//    "link": "https://example.stackexchange.com/users/1/example-user"
//},
//    "is_answered": false,
//    "view_count": 31415,
//    "favorite_count": 1,
//    "down_vote_count": 2,
//    "up_vote_count": 3,
//    "answer_count": 0,
//    "score": 1,
//    "last_activity_date": 1506916786,
//    "creation_date": 1506873586,
//    "last_edit_date": 1506941986,
//    "question_id": 1234,
//    "link": "https://example.stackexchange.com/questions/1234/an-example-post-title",
//    "title": "An example post title",
//    "body": "An example post body"
//}