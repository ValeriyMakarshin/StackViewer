package com.hodzi.stackviewer.utils

import android.content.Context
import android.support.v4.app.FragmentActivity
import android.view.inputmethod.InputMethodManager


class KeyboardUtil {
    companion object {
        fun hide(activity: FragmentActivity) {
            (activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                .hideSoftInputFromInputMethod(activity.currentFocus.windowToken, 0)
        }

    }
}
