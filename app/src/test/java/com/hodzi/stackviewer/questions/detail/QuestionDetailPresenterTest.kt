package com.hodzi.stackviewer.questions.detail

import android.os.Bundle
import com.hodzi.stackviewer.RxHook
import com.hodzi.stackviewer.model.Answer
import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.questions.QuestionsInteractor
import com.hodzi.stackviewer.utils.Generator
import com.hodzi.stackviewer.utils.Shared
import com.hodzi.stackviewer.utils.Vote
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito

internal class QuestionDetailPresenterTest {
    @Rule
    @JvmField
    val schedulers = RxHook()

    lateinit var presenterEmpty: QuestionDetailPresenter
    lateinit var presenterAuth: QuestionDetailPresenter
    lateinit var view: QuestionDetailView

    lateinit var mockBundle: Bundle
    lateinit var questionsInteractor: QuestionsInteractor
    lateinit var question: Question
    lateinit var answers: Array<Answer>
    lateinit var sharedEmpty: Shared
    lateinit var sharedAuth: Shared

    @Before
    fun setUp() {
        question = Generator.create(Question::class.java)
        mockBundle = Mockito.mock(Bundle::class.java)
        Mockito.`when`(mockBundle.getSerializable(QuestionDetailActivity.EXTRA_QUESTION))
            .thenReturn(question)

        questionsInteractor = Mockito.mock(QuestionsInteractor::class.java)

        val block: Block<Answer> = Generator.create(Block::class.java) as Block<Answer>
        answers = block.items.toTypedArray()

        Mockito.`when`(questionsInteractor.getQuestionAnswers(ArgumentMatchers.anyInt()))
            .thenReturn(Observable.just(block))

        Mockito.`when`(questionsInteractor.questionDownVote(ArgumentMatchers.anyInt(), ArgumentMatchers.anyString()))
            .thenReturn(Observable.create {
                run {
                    it.onNext(Generator.create(Question::class.java))
                    it.onComplete()
                }
            })

        sharedEmpty = Mockito.mock(Shared::class.java)
        Mockito.`when`(sharedEmpty.getToken()).thenReturn("")

        sharedAuth = Mockito.mock(Shared::class.java)
        Mockito.`when`(sharedAuth.getToken()).thenReturn("123")

        view = Mockito.mock(QuestionDetailView::class.java)

        presenterEmpty = QuestionDetailPresenter(questionsInteractor, sharedEmpty)
        presenterEmpty.view = view

        presenterAuth = QuestionDetailPresenter(questionsInteractor, sharedAuth)
        presenterAuth.view = view

    }

    @Test
    fun testAttach() {
        presenterEmpty.attach(view, mockBundle)

        verify(questionsInteractor).getQuestionAnswers(question.questionId)
        verify(view).showQuestion(question)
        verify(view).showArray(answers)
    }

    @Test
    fun testVoteEmpty() {
        presenterEmpty.vote(1, Vote.QUESTION_DOWN)

        verify(view).goToAuth()
    }

    @Test
    fun testVoteAuth() {
        presenterAuth.vote(1, Vote.QUESTION_DOWN)

        verify(view).voiceAccepted()
    }

    @Test
    fun testLoadData() {
        val question: Question = Generator.create(Question::class.java)
        presenterEmpty.question = question

        presenterEmpty.loadData()

        verify(view).showRefresh()
        verify(view).hideRefresh()
        verify(view).showArray(answers)
    }
}
