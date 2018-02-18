package com.hodzi.stackviewer

import android.app.Application
import android.content.Context
import io.appflate.restmock.android.RESTMockTestRunner

class CustomAndroidTestRunner : RESTMockTestRunner() {
    @Throws(InstantiationException::class,
        IllegalAccessException::class,
        ClassNotFoundException::class)
    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        val testApplicationClassName = TestApp::class.java.canonicalName
        return super.newApplication(cl, testApplicationClassName, context)
    }
}
