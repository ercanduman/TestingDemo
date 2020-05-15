package com.enbcreative.testingdemo.util

import android.view.WindowManager
import androidx.test.espresso.Root
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

/**
 * This is a helper class created for testing Toast messages in Kotlin
 */
class ToastMatcher : TypeSafeMatcher<Root>() {
    override fun describeTo(description: Description?) {
        description?.appendText("is toast")
    }

    override fun matchesSafely(item: Root?): Boolean {
        if (item == null) return false
        val type = item.windowLayoutParams.get().type
        if (type == WindowManager.LayoutParams.TYPE_TOAST) {
            val windowToken = item.decorView.windowToken
            val appToken = item.decorView.applicationWindowToken
            /**
             * If app token and windows token is the same,
             * this means window is not contained by any other windows
             */
            if (windowToken == appToken) return true
        }
        return false
    }
}