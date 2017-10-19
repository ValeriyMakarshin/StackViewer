package com.hodzi.stackviewer.questions.di

import com.hodzi.stackviewer.StackScope
import com.hodzi.stackviewer.questions.QuestionsInteractor
import com.hodzi.stackviewer.questions.QuestionsInteractorImpl
import com.hodzi.stackviewer.questions.QuestionsPresenter
import com.hodzi.stackviewer.questions.detail.QuestionDetailPresenter
import com.hodzi.stackviewer.utils.Api
import com.hodzi.stackviewer.utils.Shared
import dagger.Module
import dagger.Provides

@Module
class QuestionsModule {
    @Provides @StackScope
    fun provideQuestionsPresenter(questionsInteractor: QuestionsInteractor): QuestionsPresenter =
        QuestionsPresenter(questionsInteractor)

    @Provides @StackScope
    fun provideQuestionDetailPresenter(questionsInteractor: QuestionsInteractor, shared: Shared):
        QuestionDetailPresenter = QuestionDetailPresenter(questionsInteractor, shared)

    @Provides @StackScope
    fun provideQuestionsInteractor(api: Api): QuestionsInteractor = QuestionsInteractorImpl(api)
}