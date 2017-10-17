package com.hodzi.stackviewer.questions.di

import com.hodzi.stackviewer.StackScope
import com.hodzi.stackviewer.questions.QuestionsInteractor
import com.hodzi.stackviewer.questions.QuestionsInteractorImp
import com.hodzi.stackviewer.questions.QuestionsPresenter
import com.hodzi.stackviewer.questions.detail.QuestionDetailPresenter
import com.hodzi.stackviewer.utils.Api
import dagger.Module
import dagger.Provides

@Module
class QuestionsModule {
    @Provides @StackScope
    fun provideQuestionsPresenter(questionsInteractor: QuestionsInteractor): QuestionsPresenter =
        QuestionsPresenter(questionsInteractor)

    @Provides @StackScope
    fun provideQuestionDetailPresenter(questionsInteractor: QuestionsInteractor):
        QuestionDetailPresenter = QuestionDetailPresenter(questionsInteractor)

    @Provides @StackScope
    fun provideQuestionsInteractor(api: Api): QuestionsInteractor = QuestionsInteractorImp(api)
}