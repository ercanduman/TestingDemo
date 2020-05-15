package com.enbcreative.testingdemo

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
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

    @Test
    fun text_navigate_to_main() {
        onView(withId(R.id.btn_previous_second_activity)).perform(click())
        onView(withId(R.id.parent_main)).check(matches(isDisplayed()))
    }

    @Test
    fun test_nav_to_main_and_back_to_SecondActivity() {
        onView(withId(R.id.btn_previous_second_activity)).perform(click())
        onView(withId(R.id.parent_main)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_next_main)).perform(click())
        onView(withId(R.id.parent_second)).check(matches(isDisplayed()))
    }

    @Test
    fun test_launch_dialog_and_check_if_dialog_not_dismissed_after_ok_btn_click() {
        onView(withId(R.id.btn_launch_dialog_second_activity)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_launch_dialog_second_activity)).perform(click())

        // check if any member of dialog is displayed
        onView(withText(R.string.dialog_title)).check(matches(isDisplayed()))

        // then click ok button of dialog and check if dialog not dismissed
        onView(withText(android.R.string.ok)).perform(click()) // android.R.string.ok is the text we set to ok button
        onView(withText(R.string.dialog_title)).check(matches(isDisplayed())) // dialog should still be displayed
    }

    @Test
    fun test_launch_dialog_and_capture_input_data() {
        onView(withId(R.id.btn_launch_dialog_second_activity)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_launch_dialog_second_activity)).perform(click())

        // check if dialog is displayed
        onView(withId(R.id.md_input_message)).check(matches(isDisplayed())) // md_input_message is id of input layout in material dialog

        val expectedName = "Ercan"
        onView(withId(R.id.md_input_message)).perform(typeText(expectedName)) // writes name to input layout

        /** click on "ok" button and check if input text written to title_second */
        onView(withText(android.R.string.ok)).perform(click())

        // make sure dialog is gone
        onView(withId(R.id.md_input_message)).check(doesNotExist())

        // check if text set to layout
        onView(withId(R.id.title_second)).check(matches(withText(expectedName)))
    }
}