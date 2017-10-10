package com.hodzi.stackviewer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Block<out T : Data>(
    @SerializedName("items") @Expose val items: List<T>,
    @SerializedName("has_more") @Expose val hasMore: Boolean,
    @SerializedName("quota_max") @Expose val quotaMax: Int,
    @SerializedName("quota_remaining") @Expose val quotaRemaining: Int)
