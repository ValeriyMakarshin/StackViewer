package com.hodzi.stackviewer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Tag(
    @SerializedName("has_synonyms") @Expose val hasSynonyms: Boolean,
    @SerializedName("is_moderator_only") @Expose val isModeratorOnly: Boolean,
    @SerializedName("is_required") @Expose val isRequired: Boolean,
    @SerializedName("count") @Expose val count: Int,
    @SerializedName("name") @Expose val name: String
) : Data()
