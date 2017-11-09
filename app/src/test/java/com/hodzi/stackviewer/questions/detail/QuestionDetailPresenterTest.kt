package com.hodzi.stackviewer.questions.detail

import com.hodzi.stackviewer.RxHook
import com.hodzi.stackviewer.model.Answer
import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.questions.QuestionsInteractor
import com.hodzi.stackviewer.utils.Generator
import com.hodzi.stackviewer.utils.Shared
import com.hodzi.stackviewer.utils.Vote
import io.reactivex.Observable
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito


internal class QuestionDetailPresenterTest {
    companion object {
        lateinit var presenterEmpty: QuestionDetailPresenter
        lateinit var presenterAuth: QuestionDetailPresenter
        lateinit var view: QuestionDetailView

        @BeforeClass
        @JvmStatic
        fun setUp() {
            RxHook.initSchedulers()

            view = Mockito.mock(QuestionDetailView::class.java)
            val questionsInteractor: QuestionsInteractor =
                    Mockito.mock(QuestionsInteractor::class.java)

            Mockito.`when`(questionsInteractor.getQuestionAnswers(0))
                    .thenReturn(Observable.create<Block<Answer>> { s ->
                        run {
                            s.onNext(Generator.create(Block::class.java) as Block<Answer>)
                            s.onComplete()
                        }
                    })

            Mockito.`when`(questionsInteractor.questionDownVote(
                    ArgumentMatchers.anyInt(),
                    ArgumentMatchers.anyString()))
                    .thenReturn(Observable.create<Question> { s ->
                        run {
                            s.onNext(Generator.create(Question::class.java))
                            s.onComplete()
                        }
                    })

            val sharedEmpty: Shared = Mockito.mock(Shared::class.java)
            Mockito.`when`(sharedEmpty.getToken()).thenReturn("")

            val sharedAuth: Shared = Mockito.mock(Shared::class.java)
            Mockito.`when`(sharedAuth.getToken()).thenReturn("123")

            presenterEmpty = QuestionDetailPresenter(questionsInteractor, sharedEmpty)
            presenterEmpty.view = view

            presenterAuth = QuestionDetailPresenter(questionsInteractor, sharedAuth)
            presenterAuth.view = view
        }

    }

    @Test
    fun getQuestion() {
    }

    @Test
    fun setQuestion() {
    }

    @Test
    fun parseArguments() {
    }

    @Test
    fun attach() {
    }

    @Test
    fun loadData() {
    }

    @Test
    fun voteTestEmpty() {
        presenterEmpty.vote(1, Vote.QUESTION_DOWN)
        Mockito.verify(view).goToAuth()
    }

    @Test
    fun voteTestAuth() {
        presenterAuth.vote(1, Vote.QUESTION_DOWN)
        Mockito.verify(view).voiceAccepted()
    }

    @Test
    fun getQuestionsInteractor() {
    }

    @Test
    fun getShared() {
    }

}