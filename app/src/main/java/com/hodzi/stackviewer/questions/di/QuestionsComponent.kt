package com.hodzi.stackviewer.questions.di

import com.hodzi.stackviewer.App
import com.hodzi.stackviewer.questions.QuestionsActivity
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = arrayOf(QuestionsModule::class))
interface QuestionsComponent {
    fun inject(app: App)
    fun inject(questionsActivity: QuestionsActivity)
}