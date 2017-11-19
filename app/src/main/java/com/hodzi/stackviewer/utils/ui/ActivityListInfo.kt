package com.hodzi.stackviewer.utils.ui

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.ProgressBar

class ActivityListInfo(val processbar: ProgressBar? = null, val recyclerView: RecyclerView? = null,
                       val swipeLayout: SwipeRefreshLayout? = null, val refreshBtn: Button? = null)
