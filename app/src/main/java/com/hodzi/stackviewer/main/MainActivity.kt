package com.hodzi.stackviewer.main

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.di.Injector
import com.hodzi.stackviewer.questions.QuestionsFragment
import com.hodzi.stackviewer.tags.TagsFragment
import com.hodzi.stackviewer.utils.base.BaseActivity
import com.hodzi.stackviewer.utils.ui.ActivityInfo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_toolbar.*

private const val SCREEN_KEY = "screenKey"

class MainActivity : BaseActivity<MainView, MainPresenter>(),
    MainView, NavigationView.OnNavigationItemSelectedListener {

    private var lastScreen: Int = 0


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
        uiMainDl.closeDrawer(GravityCompat.START)

        val id = item.itemId

        var fragment: Fragment? = null

        if (id != lastScreen)
            lastScreen = id
        else
            return true

        when (id) {
            R.id.nav_questions -> {
                fragment = QuestionsFragment()
            }
            R.id.nav_tags -> {
                fragment = TagsFragment()
            }
            R.id.nav_users -> {

            }
            R.id.nav_settings -> {

            }
        }

        if (fragment != null)
            openFragment(fragment)

        return true
    }

    private fun openFragment(fragment: Fragment = QuestionsFragment()) {
        supportFragmentManager
            .popBackStack(fragment.tag, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
            .replace(R.id.uiContentFl, fragment)
            .commit()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putInt(SCREEN_KEY, lastScreen)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        lastScreen = savedInstanceState?.getInt(SCREEN_KEY, 0)!!
        super.onRestoreInstanceState(savedInstanceState)
    }
}
