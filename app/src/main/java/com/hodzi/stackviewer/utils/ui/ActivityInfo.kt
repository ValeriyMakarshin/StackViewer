package com.hodzi.stackviewer.utils.ui

import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v7.widget.Toolbar

/**
 * Created by yaroslavsudnik on 12/04/17.
 */

class ActivityInfo(@LayoutRes val layoutId: Int, val toolbar: Toolbar? = null,
                   @StringRes title: Int? = null) {

    init {
        title?.let { toolbar?.setTitle(it) }
    }

}
