package com.hodzi.stackviewer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Answer(
    @SerializedName("owner") @Expose val owner: Owner,
    @SerializedName("is_accepted") @Expose val isAccepted: Boolean,
    @SerializedName("score") @Expose val score: Int,
    @SerializedName("last_activity_date") @Expose val lastActivityDate: Int,
    @SerializedName("last_edit_date") @Expose val lastEditDate: Int,
    @SerializedName("creation_date") @Expose val creationDate: Int,
    @SerializedName("answer_id") @Expose val answerId: Int,
    @SerializedName("question_id") @Expose val questionId: Int,
    @SerializedName("body") @Expose val body: String
) : Data()
