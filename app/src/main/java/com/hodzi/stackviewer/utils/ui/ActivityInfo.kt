package com.hodzi.stackviewer.utils.ui

import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v7.widget.Toolbar

/**
 * Created by yaroslavsudnik on 12/04/17.
 */

class ActivityInfo {

    @LayoutRes
    val layoutId: Int
    var toolbar: Toolbar? = null


//    constructor(@LayoutRes layoutId: Int) {
//        this.layoutId = layoutId
//    }
//
//    constructor(@LayoutRes layoutId: Int, toolbar: Toolbar) {
//        this.layoutId = layoutId
//        this.toolbar = toolbar
//    }

    constructor(@LayoutRes layoutId: Int, toolbar: Toolbar? = null, @StringRes title: Int? = null) {
        this.layoutId = layoutId
        title?.let { toolbar?.setTitle(it) }
        this.toolbar = toolbar
    }
}
