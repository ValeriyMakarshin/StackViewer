package com.hodzi.stackviewer.utils

import android.os.Build
import android.support.v4.content.ContextCompat
import android.view.View

fun View.setBackgroundEx(res: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
        this.background = ContextCompat.getDrawable(context, res)
    else
        this.setBackgroundResource(res)
}