package com.hodzi.stackviewer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BadgeCounts(
    @SerializedName("bronze") @Expose var bronze: Int,
    @SerializedName("silver") @Expose var silver: Int,
    @SerializedName("gold") @Expose var gold: Int
)
