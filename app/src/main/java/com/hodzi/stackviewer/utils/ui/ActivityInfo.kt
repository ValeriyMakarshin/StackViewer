package com.hodzi.stackviewer.utils.ui

import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v7.widget.Toolbar

data class ActivityInfo(@LayoutRes val layoutId: Int, val toolbar: Toolbar? = null,
                        @StringRes val title: Int? = null,
                        val activityListInfo: ActivityListInfo? = null) {

    init {
        title?.let { toolbar?.setTitle(it) }
    }

}
