package com.hodzi.stackviewer.questions.di

import com.hodzi.stackviewer.UserScope
import com.hodzi.stackviewer.questions.QuestionsInteractor
import com.hodzi.stackviewer.questions.QuestionsPresenter
import com.stackviewer.medium.utils.Api
import dagger.Module
import dagger.Provides

@Module
class QuestionsModule {
    @Provides @UserScope
    fun provideQuestionsPresenter(questionsInteractor: QuestionsInteractor): QuestionsPresenter =
        QuestionsPresenter(questionsInteractor)

    @Provides @UserScope
    fun provideQuestionsInteractor(api : Api): QuestionsInteractor = QuestionsInteractor(api)
}