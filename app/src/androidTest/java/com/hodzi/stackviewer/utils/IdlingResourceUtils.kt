package com.hodzi.stackviewer.utils

import android.support.test.espresso.IdlingRegistry
import android.support.test.espresso.IdlingResource

class IdlingResourceUtils(private val waitTimeMs: Long) : IdlingResource {
    companion object {
        fun timeout(waitTimeMs: Long): IdlingResource {
            val idlingResource: IdlingResource = IdlingResourceUtils(waitTimeMs)
            IdlingRegistry.getInstance().register(idlingResource)
            return idlingResource
        }
    }

    private var startTime: Long = System.currentTimeMillis()
    private var callback: IdlingResource.ResourceCallback? = null

    override fun getName(): String = this.javaClass.name

    override fun isIdleNow(): Boolean {
        val isIdle: Boolean = System.currentTimeMillis() - startTime >= waitTimeMs
        if (isIdle) {
            callback?.onTransitionToIdle()
        }
        return isIdle
    }

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback?) {
        this.callback = callback
    }
}
