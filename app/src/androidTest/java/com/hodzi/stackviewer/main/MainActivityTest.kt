package com.hodzi.stackviewer.main

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.DrawerActions.open
import android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.Gravity
import com.hodzi.stackviewer.Const
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.adapters.holders.QuestionsHolder
import com.hodzi.stackviewer.utils.TestIdlingResource
import org.hamcrest.CoreMatchers.not
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep


@RunWith(AndroidJUnit4::class)
internal class MainActivityTest {
    companion object {
        @BeforeClass
        @JvmStatic
        fun set() {
            TestIdlingResource.timeout(Const.UI_TEST_TIMEOUT)
        }
    }

    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

//    @Before
//    @Throws(Exception::class)
//    fun setUp() {
//        Intents.init()
//    }

    @Test
    @Throws(Exception::class)
    fun testNavigationView() {
        onView(withId(R.id.uiMainNv)).check(matches(not(isDisplayed())))
        onView(withId(R.id.uiMainDl)).perform(open(Gravity.LEFT))
        onView(withId(R.id.uiMainNv)).check(matches(isDisplayed()))
        mActivityRule.activity.onBackPressed()
        sleep(1000)
        onView(withId(R.id.uiMainNv)).check(matches(not(isDisplayed())))
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