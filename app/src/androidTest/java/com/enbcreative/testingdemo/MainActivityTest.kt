package com.enbcreative.testingdemo

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
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
}