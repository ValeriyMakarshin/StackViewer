package com.hodzi.stackviewer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User(
    @SerializedName("badge_counts") @Expose val badgeCounts: BadgeCounts,
    @SerializedName("account_id") @Expose val accountId: Int,
    @SerializedName("is_employee") @Expose val isEmployee: Boolean,
    @SerializedName("last_modified_date") @Expose val lastModifiedDate: Int,
    @SerializedName("last_access_date") @Expose val lastAccessDate: Int,
    @SerializedName("age") @Expose val age: Int,
    @SerializedName("reputation_change_year") @Expose val reputationChangeYear: Int,
    @SerializedName("reputation_change_quarter") @Expose val reputationChangeQuarter: Int,
    @SerializedName("reputation_change_month") @Expose val reputationChangeMonth: Int,
    @SerializedName("reputation_change_week") @Expose val reputationChangeWeek: Int,
    @SerializedName("reputation_change_day") @Expose val reputationChangeDay: Int,
    @SerializedName("reputation") @Expose val reputation: Int,
    @SerializedName("creation_date") @Expose val creationDate: Int,
    @SerializedName("user_type") @Expose val userType: UserType,
    @SerializedName("user_id") @Expose val userId: Int,
    @SerializedName("accept_rate") @Expose val acceptRate: Int,
    @SerializedName("location") @Expose val location: String,
    @SerializedName("website_url") @Expose val websiteUrl: String,
    @SerializedName("link") @Expose val link: String,
    @SerializedName("profile_image") @Expose val profileImage: String,
    @SerializedName("display_name") @Expose val displayName: String
) : Data()
