package com.enbcreative.testingdemo.fragments

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.enbcreative.testingdemo.FragmentsActivity
import com.enbcreative.testingdemo.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class FirstFragmentTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(FragmentsActivity::class.java)

    @Test
    fun test_is_fragment_visible() {
        onView(withId(R.id.parent_fragment_first)).check(matches(isDisplayed()))
    }

    @Test
    fun test_is_fragment_next_button_visible() {
        onView(withId(R.id.btn_fragment_first)).check(matches(isDisplayed()))
    }

    @Test
    fun test_click_on_next_button_and_check_second_fragment_is_displayed() {
        onView(withId(R.id.btn_fragment_first)).perform(click())
        onView(withId(R.id.parent_fragment_second)).check(matches(isDisplayed()))
    }

    @Test
    fun test_click_on_next_button_and_check_second_fragment_is_displayed_and_title_has_text() {
        onView(withId(R.id.btn_fragment_first)).perform(click())
        onView(withId(R.id.parent_fragment_second)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_fragment_second)).check(matches(withText(R.string.hello_second_fragment)))
    }

    @Test
    fun test_click_on_next_button_and_check_second_fragment_is_displayed_and_press_back_to_first_fragment() {
        onView(withId(R.id.btn_fragment_first)).perform(click())
        onView(withId(R.id.parent_fragment_second)).check(matches(isDisplayed()))
        pressBack()
        onView(withId(R.id.parent_fragment_first)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }
}