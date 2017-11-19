package com.hodzi.stackviewer.users

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.DrawerActions
import android.support.test.espresso.contrib.DrawerMatchers
import android.support.test.espresso.contrib.NavigationViewActions
import android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.Gravity
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.adapters.holders.UsersHolder
import com.hodzi.stackviewer.main.MainActivity
import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UsersFragmentTest {
    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    fun setUp() {
        onView(withId(R.id.uiMainDl))
                .check(matches(DrawerMatchers.isClosed(Gravity.LEFT)))
                .perform(DrawerActions.open())
        onView(withId(R.id.uiMainNv))
                .perform(NavigationViewActions.navigateTo(R.id.nav_users))
    }

    @Test
    @Throws(Exception::class)
    fun testRecyclerViewDisplayed() {
        onView(withId(R.id.uiRefreshBt)).check(matches(CoreMatchers.not(isDisplayed())))
        onView(withId(R.id.uiUsersRv)).check(matches(isDisplayed()))
    }

    @Test
    @Throws(Exception::class)
    fun testRecyclerViewScroll() {
        onView(withId(R.id.uiUsersRv))
                .perform(scrollToPosition<UsersHolder>(20))
                .perform(scrollToPosition<UsersHolder>(2))
                .perform(scrollToPosition<UsersHolder>(4))
                .perform(scrollToPosition<UsersHolder>(1))
                .perform(scrollToPosition<UsersHolder>(15))
                .perform(scrollToPosition<UsersHolder>(190))
    }
}