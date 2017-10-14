package com.hodzi.stackviewer.utils.ui

import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.ProgressBar

class ActivityListInfo(val recyclerView: RecyclerView? = null, val processbar: ProgressBar? = null,
                       val swipeLayout: SwipeRefreshLayout? = null, val updateList: Button? = null)
