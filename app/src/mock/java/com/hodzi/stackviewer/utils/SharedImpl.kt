package com.hodzi.stackviewer.utils

import android.content.SharedPreferences

class SharedImpl(val sharedPreferences: SharedPreferences) : Shared {
    override fun saveToken(token: String?) {
    }

    override fun getToken(): String = "1234567890"
}
