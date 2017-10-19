package com.hodzi.stackviewer.utils

import android.content.SharedPreferences
import com.hodzi.stackviewer.utils.Shared.Companion.KEY_TOKEN

class SharedImpl(val sharedPreferences: SharedPreferences) : Shared {
    override fun setToken(token: String) {
        sharedPreferences.edit()
            .putString(KEY_TOKEN, token)
            .apply()

    }

    override fun getToken(): String = sharedPreferences.getString(KEY_TOKEN, EMPTY_STRING)

}