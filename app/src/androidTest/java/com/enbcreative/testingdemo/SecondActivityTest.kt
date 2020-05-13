package com.enbcreative.testingdemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondActivityTest {
    /**
     * Declared a rule, so no need to create activity scenario for each test
     *
     * To make it public can use one of the below option
     *  1 - @Rule @JvmField
     *  2 - @get:Rule
     */
    @get:Rule
    val activityRule = ActivityScenarioRule(SecondActivity::class.java)

    @Test
    fun test_is_activity_on_view_displayed() {
        onView(withId(R.id.parent_second)).check(matches(isDisplayed()))
    }

    @Test
    fun test_check_visibility_title_and_back_button() {
        onView(withId(R.id.title_second)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_previous_second_activity)).check(
            matches(withEffectiveVisibility(Visibility.VISIBLE))
        )
    }

    @Test
    fun is_title_contains_specific_text() {
        onView(withId(R.id.title_second)).check(matches(withText(R.string.title_second)))
    }
}