package com.hodzi.stackviewer.main

import android.content.Intent
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
import com.hodzi.stackviewer.login.LoginActivity
import com.hodzi.stackviewer.questions.QuestionsFragment
import com.hodzi.stackviewer.tags.TagsFragment
import com.hodzi.stackviewer.users.UsersFragment
import com.hodzi.stackviewer.utils.base.BaseActivity
import com.hodzi.stackviewer.utils.ui.ActivityInfo
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_toolbar.*

class MainActivity : BaseActivity<MainView, MainPresenter>(),
    MainView, NavigationView.OnNavigationItemSelectedListener {
    companion object {
        private const val SCREEN_KEY = "screenKey"
    }

    private var lastScreen: Int = 0


    override fun getActivityInfo(): ActivityInfo =
        ActivityInfo(R.layout.activity_main, uiToolbar, R.string.app_name)

    override fun onCreate(savedInstanceState: Bundle?) {
        Injector.inject(this)
        super.onCreate(savedInstanceState)

        val toggle = ActionBarDrawerToggle(this, uiMainDl, uiToolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        uiMainDl.addDrawerListener(toggle)
        toggle.syncState()

        uiMainNv.setNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        return if (id == R.id.action_settings) {

//            Navigator.auth(this)
            startActivity(Intent(this, LoginActivity::class.java))
            return true
        } else {
            super.onOptionsItemSelected(item)
        }
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

        if (id != lastScreen)
            lastScreen = id
        else
            return true

        startFragment(id)
        return true
    }

    private fun startFragment(id: Int) {
        val fragment: Fragment? =
            when (id) {
                R.id.nav_questions -> {
                    uiToolbar.setTitle(R.string.nav_questions)
                    QuestionsFragment()
                }
                R.id.nav_tags      -> {
                    uiToolbar.setTitle(R.string.nav_tags)
                    TagsFragment()
                }
                R.id.nav_users     -> {
                    uiToolbar.setTitle(R.string.nav_users)
                    UsersFragment()
                }
                else               -> {
                    lastScreen = R.id.nav_tags
                    uiToolbar.setTitle(R.string.nav_tags)
                    TagsFragment()
                }
            }

        if (fragment != null)
            openFragment(fragment)
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
        lastScreen = savedInstanceState?.getInt(SCREEN_KEY, R.id.nav_questions)!!
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        startFragment(lastScreen)
    }
}
