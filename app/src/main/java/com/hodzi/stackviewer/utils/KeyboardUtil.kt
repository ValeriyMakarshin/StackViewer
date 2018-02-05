package com.hodzi.stackviewer.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager


class KeyboardUtil {
    companion object {
        fun hide(activity: Activity) {
            (activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                .hideSoftInputFromInputMethod(activity.currentFocus.windowToken, 0)
        }

    }
}
