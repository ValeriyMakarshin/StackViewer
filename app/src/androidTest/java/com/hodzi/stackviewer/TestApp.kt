package com.hodzi.stackviewer

import com.hodzi.stackviewer.di.NetModule

class TestApp : App() {
    override fun getNetModule(): NetModule {
        return AndroidTestNetModule(this)
    }
}
