package com.enbcreative.testingdemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.enbcreative.testingdemo.util.ToastMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class FragmentsActivityTest {
    @get:Rule
    val testRule = ActivityScenarioRule(FragmentsActivity::class.java)

    @Test
    fun test_click_fab_and_check_if_toast_is_displayed() {
        // check if fab button is visible
        onView(withId(R.id.fab_activity_fragments)).check(matches(isDisplayed()))

        // click on fab button
        onView(withId(R.id.fab_activity_fragments)).perform(click())

        // check if toast displayed
        onView(withText(R.string.toast_message)).inRoot(ToastMatcher())
            .check(matches(isDisplayed()))
    }
}