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
    @SerializedName("body") @Expose val body: String) : Data()
