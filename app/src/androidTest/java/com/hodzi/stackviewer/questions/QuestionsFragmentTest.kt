package com.hodzi.stackviewer.questions

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.adapters.holders.QuestionsHolder
import com.hodzi.stackviewer.main.MainActivity
import com.hodzi.stackviewer.questions.detail.QuestionDetailActivity
import org.hamcrest.CoreMatchers.not
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
internal class QuestionsFragmentTest {
    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
    }

    @Test
    @Throws(Exception::class)
    fun testRecyclerViewDisplayed() {
        onView(withId(R.id.uiRefreshBt)).check(matches(not(isDisplayed())))
        onView(withId(R.id.uiQuestionsRv)).check(matches(isDisplayed()))
    }

    @Test
    @Throws(Exception::class)
    fun testClickOnItem() {
        onView(withId(R.id.uiQuestionsRv))
            .perform(actionOnItemAtPosition<QuestionsHolder>(4, click()))

        Intents.intended(hasComponent(QuestionDetailActivity::class.java.name))
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        Intents.release()
    }
}