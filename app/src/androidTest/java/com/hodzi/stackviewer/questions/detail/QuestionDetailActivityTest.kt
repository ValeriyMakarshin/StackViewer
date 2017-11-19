package com.hodzi.stackviewer.questions.detail

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import android.support.test.espresso.matcher.RootMatchers.withDecorView
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.adapters.holders.AnswersHolder
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.utils.Generator
import com.hodzi.stackviewer.utils.withIndex
import org.hamcrest.Matchers.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class QuestionDetailActivityTest {

    @Rule
    @JvmField
    val activityTestRule =
        ActivityTestRule<QuestionDetailActivity>(QuestionDetailActivity::class.java,
            false, false)


    @Before
    fun setUp() {
        val intent = Intent()
        val question: Question = Generator.create(Question::class.java)
        intent.putExtra(QuestionDetailActivity.EXTRA_QUESTION, question)
        activityTestRule.launchActivity(intent)
    }

    @Test
    @Throws(Exception::class)
    fun testRecyclerViewDisplayed() {
        onView(withId(R.id.uiRefreshBt)).check(matches(not(isDisplayed())))
        onView(withId(R.id.uiAnswersRv)).check(matches(isDisplayed()))
    }

    @Test
    @Throws(Exception::class)
    fun testRecyclerViewScroll() {
        onView(withId(R.id.uiAnswersRv))
                .perform(scrollToPosition<AnswersHolder>(20))
                .perform(scrollToPosition<AnswersHolder>(2))
                .perform(scrollToPosition<AnswersHolder>(4))
                .perform(scrollToPosition<AnswersHolder>(1))
                .perform(scrollToPosition<AnswersHolder>(15))
    }

    @Test
    @Throws(Exception::class)
    fun testQuestionVote() {
        onView(allOf(withId(R.id.uiArrowUpIv), not(isDescendantOfA(withId(R.id.uiAnswersRv)))))
            .perform(click())
        onView(withText(R.string.voice_accepted))
            .inRoot(withDecorView(not(`is`(activityTestRule.activity.window.decorView))))
            .check(matches(isDisplayed()))
    }

    @Test
    @Throws(Exception::class)
    fun testAnswerVote() {
        onView(withId(R.id.uiAnswersRv).withIndex(withId(R.id.uiArrowUpIv), 0)).perform(click())
        onView(withText(R.string.voice_accepted))
            .inRoot(withDecorView(not(`is`(activityTestRule.activity.window.decorView))))
            .check(matches(isDisplayed()))
    }

}