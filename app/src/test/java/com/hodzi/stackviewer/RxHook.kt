package com.hodzi.stackviewer

import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class RxHook : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                val immediate = Schedulers.trampoline()
                RxJavaPlugins.setIoSchedulerHandler { immediate }
                RxJavaPlugins.setComputationSchedulerHandler { immediate }
                RxJavaPlugins.setNewThreadSchedulerHandler { immediate }
                RxJavaPlugins.setSingleSchedulerHandler { immediate }
                RxAndroidPlugins.setInitMainThreadSchedulerHandler { immediate }
                try {
                    base.evaluate()
                } finally {
                    RxJavaPlugins.reset()
                }
            }
        }
    }
}
