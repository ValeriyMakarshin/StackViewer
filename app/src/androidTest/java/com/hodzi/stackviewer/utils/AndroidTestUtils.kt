package com.hodzi.stackviewer.utils

import android.view.View
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

fun Matcher<View>.withIndex(matcher: Matcher<View>, index: Int): Matcher<View> {
    return object : TypeSafeMatcher<View>() {
        internal var currentIndex = 0

        override fun describeTo(description: Description) {
            description.appendText("with index: ")
            description.appendValue(index)
            matcher.describeTo(description)
        }

        override fun matchesSafely(view: View): Boolean =
            matcher.matches(view) && currentIndex++ == index
    }
}