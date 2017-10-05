package com.hodzi.stackviewer

import android.app.Application
import com.hodzi.stackviewer.di.*
import com.hodzi.stackviewer.questions.di.QuestionsComponent
import com.hodzi.stackviewer.questions.di.QuestionsModule

class App : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .netModule(NetModule())
            .appModule(AppModule(this))
            .appModule(AppModule(this))
            .build()
    }

    val questionsComponent: QuestionsComponent by lazy {
        appComponent.plus(QuestionsModule())
    }

    override fun onCreate() {
        super.onCreate()
        Injector.inject(this)
        NetUtils.init(this)
    }

}

