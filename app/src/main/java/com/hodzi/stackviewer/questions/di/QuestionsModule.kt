package com.hodzi.stackviewer.questions.di

import com.hodzi.stackviewer.questions.QuestionsInteractor
import com.hodzi.stackviewer.questions.QuestionsPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class QuestionsModule {
    @Provides @Singleton
    fun provideQuestionsPresenter(questionsInteractor: QuestionsInteractor): QuestionsPresenter {
        return QuestionsPresenter(questionsInteractor)
    }
}