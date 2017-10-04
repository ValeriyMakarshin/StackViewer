package com.hodzi.stackviewer

import android.app.Application
import com.hodzi.stackviewer.di.*
import com.hodzi.stackviewer.questions.di.QuestionsComponent
import com.hodzi.stackviewer.questions.di.QuestionsModule

class App : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
                .build()
                .netModule(NetModule())
                .appModule(AppModule(this))
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

