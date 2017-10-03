package com.hodzi.stackviewer

import android.app.Application
import com.hodzi.stackviewer.di.*
import com.hodzi.stackviewer.questions.di.QuestionsComponent
import com.hodzi.stackviewer.questions.di.QuestionsModule

class App : Application() {
    private var appComponent: AppComponent? = null
    private var questionsComponent: QuestionsComponent? = null

    override fun onCreate() {
        super.onCreate()
        initializeModules()
        Injector.inject(this)
        NetUtils.init(this)
    }


    fun initializeModules() {
        appComponent = createAppComponent()
        questionsComponent = appComponent?.plus(QuestionsModule())
    }

    fun createAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .netModule(NetModule())
                .build()
    }


    fun getQuestionsComponent(): QuestionsComponent? = questionsComponent

}
