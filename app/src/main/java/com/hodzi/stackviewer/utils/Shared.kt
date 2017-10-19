package com.hodzi.stackviewer.utils

interface Shared {
    companion object {
        const val KEY_TOKEN: String = "keyToken"
    }

    fun getToken(): String

    fun setToken(token: String)
}
