package com.hodzi.stackviewer.questions.di

import com.hodzi.stackviewer.UserScope
import com.hodzi.stackviewer.questions.QuestionsActivity
import dagger.Subcomponent

@UserScope
@Subcomponent(modules = arrayOf(QuestionsModule::class))
interface QuestionsComponent {
    fun inject(questionsActivity: QuestionsActivity)
}