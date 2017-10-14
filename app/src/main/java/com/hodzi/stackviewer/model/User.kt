package com.hodzi.stackviewer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User(
    @SerializedName("badge_counts") @Expose val badgeCounts: BadgeCounts? = null,
    @SerializedName("account_id") @Expose val accountId: Int? = null,
    @SerializedName("is_employee") @Expose val isEmployee: Boolean? = null,
    @SerializedName("last_modified_date") @Expose val lastModifiedDate: Int? = null,
    @SerializedName("last_access_date") @Expose val lastAccessDate: Int? = null,
    @SerializedName("age") @Expose val age: Int? = null,
    @SerializedName("reputation_change_year") @Expose val reputationChangeYear: Int? = null,
    @SerializedName("reputation_change_quarter") @Expose val reputationChangeQuarter: Int? = null,
    @SerializedName("reputation_change_month") @Expose val reputationChangeMonth: Int? = null,
    @SerializedName("reputation_change_week") @Expose val reputationChangeWeek: Int? = null,
    @SerializedName("reputation_change_day") @Expose val reputationChangeDay: Int? = null,
    @SerializedName("reputation") @Expose val reputation: Int? = null,
    @SerializedName("creation_date") @Expose val creationDate: Int? = null,
    @SerializedName("user_type") @Expose val userType: String? = null,
    @SerializedName("user_id") @Expose val userId: Int? = null,
    @SerializedName("accept_rate") @Expose val acceptRate: Int? = null,
    @SerializedName("location") @Expose val location: String? = null,
    @SerializedName("website_url") @Expose val websiteUrl: String? = null,
    @SerializedName("link") @Expose val link: String? = null,
    @SerializedName("profile_image") @Expose val profileImage: String? = null,
    @SerializedName("display_name") @Expose val displayName: String? = null
)
