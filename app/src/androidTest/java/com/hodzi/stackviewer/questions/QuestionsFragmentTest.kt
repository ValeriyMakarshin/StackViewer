package com.hodzi.stackviewer.questions

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.adapters.holders.QuestionsHolder
import com.hodzi.stackviewer.main.MainActivity
import com.hodzi.stackviewer.questions.detail.QuestionDetailActivity
import io.appflate.restmock.RESTMockServer
import io.appflate.restmock.utils.RequestMatchers.pathContains
import org.hamcrest.CoreMatchers.allOf
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
    val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()

        RESTMockServer.reset()
        RESTMockServer.whenGET(pathContains("/questions\$"))
            .thenReturnFile(200, "questions.json")
    }

    @Test
    @Throws(Exception::class)
    fun testRecyclerViewDisplayed() {
        onView(withId(R.id.uiRefreshBt)).check(matches(not(isDisplayed())))
        onView(withId(R.id.uiQuestionsRv)).check(matches(isDisplayed()))
    }

    @Test
    @Throws(Exception::class)
    fun testRecyclerViewScroll() {
        onView(withId(R.id.uiQuestionsRv))
            .perform(scrollToPosition<RecyclerView.ViewHolder>(20))
            .perform(scrollToPosition<QuestionsHolder>(2))
            .perform(scrollToPosition<QuestionsHolder>(4))
            .perform(scrollToPosition<QuestionsHolder>(1))
            .perform(scrollToPosition<QuestionsHolder>(15))
            .perform(scrollToPosition<QuestionsHolder>(190))
    }

    @Test
    @Throws(Exception::class)
    fun testClickOnItem() {
        onView(withId(R.id.uiQuestionsRv))
            .perform(actionOnItemAtPosition<QuestionsHolder>(3, click()))
        Intents.intended(allOf(
            hasComponent(QuestionDetailActivity::class.java.name),
            hasExtraWithKey(QuestionDetailActivity.EXTRA_QUESTION)))
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        Intents.release()
    }
}
