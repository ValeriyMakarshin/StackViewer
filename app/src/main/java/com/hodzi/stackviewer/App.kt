package com.hodzi.stackviewer

import android.app.Application
import com.hodzi.stackviewer.di.AppComponent
import com.hodzi.stackviewer.di.Injector

class App : Application() {
    private var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        initializeModules()
        Injector.inject(this)
//        NetUtils.init(this)
    }


    fun initializeModules() {
//        appComponent = createAppComponent()
    }

//    fun createAppComponent(): AppComponent {
//        return DaggerAppComponent.builder()
//                .appModule(AppModule(this))
//                .netModule(NetModule(BuildConfig.API_BASE_URL))
//                .build()
//
//    }
}
