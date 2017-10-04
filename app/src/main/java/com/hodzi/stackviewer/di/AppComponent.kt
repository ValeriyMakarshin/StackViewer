package com.hodzi.stackviewer.di

import com.hodzi.stackviewer.App
import com.hodzi.stackviewer.questions.di.QuestionsComponent
import com.hodzi.stackviewer.questions.di.QuestionsModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetModule::class))
interface AppComponent {

    fun inject(app: App)

    fun plus(questionsModule: QuestionsModule): QuestionsComponent
}
