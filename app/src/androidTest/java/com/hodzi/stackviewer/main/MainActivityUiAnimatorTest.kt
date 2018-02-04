package com.hodzi.stackviewer.main

import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule
import android.support.test.rule.GrantPermissionRule
import android.support.test.runner.AndroidJUnit4
import android.support.test.uiautomator.UiDevice
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityUiAnimatorTest {

    private var mDevice: UiDevice? = null

    @Rule
    @JvmField
    val mActivityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Rule
    @JvmField
    val mRuntimePermissionRule: GrantPermissionRule =
        GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION)

    @Before
    fun setUp() {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    @Throws(Exception::class)
    fun testNavigationView() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        device.pressHome()
        Thread.sleep(5000)
        device.openNotification()
        Thread.sleep(5000)
    }
}