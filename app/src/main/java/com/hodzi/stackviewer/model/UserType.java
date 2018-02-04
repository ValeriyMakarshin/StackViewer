package com.hodzi.stackviewer.model;

import com.google.gson.annotations.SerializedName;

public enum UserType {
    @SerializedName("moderator")
    MODERATOR,
    @SerializedName("registered")
    REGISTERED
}
