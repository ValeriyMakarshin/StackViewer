package com.hodzi.stackviewer.main

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.IdlingRegistry
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.DrawerActions
import android.support.test.espresso.contrib.DrawerActions.open
import android.support.test.espresso.contrib.DrawerMatchers.isClosed
import android.support.test.espresso.contrib.NavigationViewActions
import android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.Gravity
import com.hodzi.stackviewer.Const
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.adapters.holders.QuestionsHolder
import com.hodzi.stackviewer.utils.IdlingResourceUtils
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
internal class MainActivityTest {
    companion object {
//        private lateinit var idlingResource : IdlingResource

        @BeforeClass
        @JvmStatic
        fun set() {
//            idlingResource = IdlingResourceUtils.timeout(Const.UI_TEST_TIMEOUT)
        }
    }

    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun testNavigationView() {
        onView(withId(R.id.uiMainNv)).check(matches(not(isDisplayed())))
        onView(withId(R.id.uiMainDl)).perform(open(Gravity.LEFT))
        onView(withId(R.id.uiMainNv)).check(matches(isDisplayed()))

        mActivityRule.activity.onBackPressed()
        val idlingResource = IdlingResourceUtils.timeout(Const.UI_TEST_TIMEOUT)
        onView(withId(R.id.uiMainNv)).check(matches(not(isDisplayed())))
        IdlingRegistry.getInstance().unregister(idlingResource)
    }

    @Test
    @Throws(Exception::class)
    fun testOpenUsers() {
        onView(allOf(withText(R.string.nav_questions), withParent(withId(R.id.uiToolbar))))
            .check(matches(isDisplayed()))
        onView(withId(R.id.uiQuestionsRv))
            .check(matches(isDisplayed()))

        onView(withId(R.id.uiMainDl))
            .check(matches(isClosed(Gravity.LEFT)))
            .perform(DrawerActions.open())
        onView(withId(R.id.uiMainNv))
            .perform(NavigationViewActions.navigateTo(R.id.nav_tags))
        onView(allOf(withText(R.string.nav_tags), withParent(withId(R.id.uiToolbar))))
            .check(matches(isDisplayed()))
        onView(withId(R.id.uiTagsRv))
            .check(matches(isDisplayed()))

        onView(withId(R.id.uiMainDl))
            .check(matches(isClosed(Gravity.LEFT)))
            .perform(DrawerActions.open())
        onView(withId(R.id.uiMainNv))
            .perform(NavigationViewActions.navigateTo(R.id.nav_users))
        onView(allOf(withText(R.string.nav_users), withParent(withId(R.id.uiToolbar))))
            .check(matches(isDisplayed()))
        onView(withId(R.id.uiUsersRv))
            .check(matches(isDisplayed()))

        onView(withId(R.id.uiMainDl))
            .check(matches(isClosed(Gravity.LEFT)))
            .perform(DrawerActions.open())
        onView(withId(R.id.uiMainNv))
            .perform(NavigationViewActions.navigateTo(R.id.nav_questions))
        onView(allOf(withText(R.string.nav_questions), withParent(withId(R.id.uiToolbar))))
            .check(matches(isDisplayed()))
        onView(withId(R.id.uiQuestionsRv))
            .check(matches(isDisplayed()))
    }


    @Test
    @Throws(Exception::class)
    fun testRecyclerViewDisplayed() {
        onView(withId(R.id.uiQuestionsRv))
            .perform(scrollToPosition<QuestionsHolder>(13))
            .perform(scrollToPosition<QuestionsHolder>(1))
            .perform(scrollToPosition<QuestionsHolder>(20))
    }
}
