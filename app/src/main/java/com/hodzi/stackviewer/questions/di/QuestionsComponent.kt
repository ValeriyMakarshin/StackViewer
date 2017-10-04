package com.hodzi.stackviewer.questions.di

import com.hodzi.stackviewer.questions.QuestionsActivity
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Subcomponent(modules = arrayOf(QuestionsModule::class))
interface QuestionsComponent {
    fun inject(questionsActivity: QuestionsActivity)
}