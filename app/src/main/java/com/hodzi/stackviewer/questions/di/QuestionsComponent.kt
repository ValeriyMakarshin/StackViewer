package com.hodzi.stackviewer.questions.di

import com.hodzi.stackviewer.StackScope
import com.hodzi.stackviewer.questions.QuestionsFragment
import com.hodzi.stackviewer.questions.detail.QuestionDetailActivity
import dagger.Subcomponent

@StackScope
@Subcomponent(modules = arrayOf(QuestionsModule::class))
interface QuestionsComponent {
    fun inject(questionsFragment: QuestionsFragment)

    fun inject(questionDetailActivity: QuestionDetailActivity)
}