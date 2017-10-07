package com.hodzi.stackviewer.main

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.di.Injector
import com.hodzi.stackviewer.utils.base.BaseActivity
import com.hodzi.stackviewer.utils.ui.ActivityInfo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_toolbar.*

class MainActivity : BaseActivity<MainView, MainPresenter>(),
    MainView, NavigationView.OnNavigationItemSelectedListener {

    override fun getActivityInfo(): ActivityInfo =
        ActivityInfo(R.layout.activity_main, uiToolbar, R.string.app_name)

    override fun onCreate(savedInstanceState: Bundle?) {
        Injector.inject(this)
        super.onCreate(savedInstanceState)

        val toggle = ActionBarDrawerToggle(this, uiMainDl, uiToolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        uiMainDl.setDrawerListener(toggle)
        toggle.syncState()

        uiMainNv.setNavigationItemSelectedListener(this)
    }

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

    override fun onBackPressed() {
        if (uiMainDl.isDrawerOpen(GravityCompat.START)) {
            uiMainDl.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        uiMainDl.closeDrawer(GravityCompat.START)
        return true
    }
}
