package com.enbcreative.testingdemo

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {
    @Test
    fun test_is_activity_in_view() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.parent_main)).check(matches(isDisplayed()))
    }

    @Test
    fun test_title_and_next_button_visibility() {
        ActivityScenario.launch(MainActivity::class.java)
        /**
         * Check visibility in different ways
         */
        /** 1. way */
        onView(withId(R.id.btn_next_main)).check(matches(isDisplayed()))
        /** 2. way */
        onView(withId(R.id.title_main)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun test_if_title_contains_specific_text() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.title_main)).check(matches(withText(R.string.title_main)))
    }

    @Test
    fun test_navigate_to_second_activity() {
        ActivityScenario.launch(MainActivity::class.java)

        // trigger button click
        onView(withId(R.id.btn_next_main)).perform(click())
        // check if second activity is displayed after button clicks
        onView(withId(R.id.parent_second)).check(matches(isDisplayed()))
    }

    /**
     * First way of going back to MainActivity is via clicking to back button on layout
     */
    @Test
    fun test_nav_to_second_activity_and_back_to_main() {
        //start MainActivity
        ActivityScenario.launch(MainActivity::class.java)

        // click on button
        onView(withId(R.id.btn_next_main)).perform(click())
        // check if SecondActivity is displayed
        onView(withId(R.id.parent_second)).check(matches(isDisplayed()))
        // click back button in layout
        onView(withId(R.id.btn_previous_second_activity)).perform(click())
        //check if MainActivity is displayed
        onView(withId(R.id.parent_main)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    /**
     * Second way of going back to MainActivity is via clicking by onBackPressed navigation button
     */
    @Test
    fun test_nav_to_second_activity_and_back_to_main_2() {
        // start main activity
        // click next button
        // check if second activity is visible/displayed
        // press on back button of navigation buttons
        // check if main activity is visible/displayed

        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.btn_next_main)).perform(click())
        onView(withId(R.id.parent_second)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        pressBack()
        onView(withId(R.id.parent_main)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }
}