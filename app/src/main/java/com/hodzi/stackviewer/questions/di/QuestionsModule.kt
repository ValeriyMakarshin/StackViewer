package com.hodzi.stackviewer.questions.di

import com.hodzi.stackviewer.StackScope
import com.hodzi.stackviewer.questions.QuestionContract
import com.hodzi.stackviewer.questions.QuestionsInteractor
import com.hodzi.stackviewer.questions.QuestionsInteractorImpl
import com.hodzi.stackviewer.questions.QuestionsPresenter
import com.hodzi.stackviewer.questions.detail.QuestionDetailContract
import com.hodzi.stackviewer.questions.detail.QuestionDetailPresenter
import com.hodzi.stackviewer.utils.Api
import com.hodzi.stackviewer.utils.Shared
import dagger.Module
import dagger.Provides

@Module
class QuestionsModule {
    @Provides @StackScope
    fun provideQuestionsPresenter(questionsInteractor: QuestionsInteractor):
        QuestionContract.Presenter = QuestionsPresenter(questionsInteractor)

    @Provides @StackScope
    fun provideQuestionDetailPresenter(questionsInteractor: QuestionsInteractor, shared: Shared):
        QuestionDetailContract.Presenter = QuestionDetailPresenter(questionsInteractor, shared)

    @Provides @StackScope
    fun provideQuestionsInteractor(api: Api): QuestionsInteractor = QuestionsInteractorImpl(api)
}
