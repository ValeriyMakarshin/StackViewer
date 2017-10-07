package com.hodzi.stackviewer.questions.di

import com.hodzi.stackviewer.UserScope
import com.hodzi.stackviewer.questions.QuestionsFragment
import dagger.Subcomponent

@UserScope
@Subcomponent(modules = arrayOf(QuestionsModule::class))
interface QuestionsComponent {
    fun inject(questionsFragment: QuestionsFragment)
}