package com.hodzi.stackviewer.tags

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.DrawerActions
import android.support.test.espresso.contrib.DrawerMatchers
import android.support.test.espresso.contrib.NavigationViewActions
import android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.view.Gravity
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.adapters.holders.TagsHolder
import com.hodzi.stackviewer.main.MainActivity
import org.hamcrest.CoreMatchers.not
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TagsFragmentTest {
    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    fun setUp() {
        onView(withId(R.id.uiMainDl))
                .check(matches(DrawerMatchers.isClosed(Gravity.LEFT)))
                .perform(DrawerActions.open())
        onView(withId(R.id.uiMainNv))
                .perform(NavigationViewActions.navigateTo(R.id.nav_tags))
    }

    @Test
    @Throws(Exception::class)
    fun testRecyclerViewDisplayed() {
        onView(withId(R.id.uiRefreshBt)).check(matches(not(isDisplayed())))
        onView(withId(R.id.uiTagsRv)).check(matches(isDisplayed()))
    }

    @Test
    @Throws(Exception::class)
    fun testRecyclerViewScroll() {
        Espresso.onView(ViewMatchers.withId(R.id.uiTagsRv))
                .perform(scrollToPosition<TagsHolder>(20))
                .perform(scrollToPosition<TagsHolder>(2))
                .perform(scrollToPosition<TagsHolder>(4))
                .perform(scrollToPosition<TagsHolder>(1))
                .perform(scrollToPosition<TagsHolder>(15))
    }
}