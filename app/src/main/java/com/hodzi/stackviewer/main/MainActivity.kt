package com.hodzi.stackviewer.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.utils.base.BaseActivity
import com.hodzi.stackviewer.utils.ui.ActivityInfo

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {
    override fun getActivityInfo(): ActivityInfo = ActivityInfo(R.layout.activity_main)

    override fun parseArguments(extras: Bundle) {

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

}
