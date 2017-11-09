package com.hodzi.stackviewer.questions.detail

import com.hodzi.stackviewer.model.Answer
import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.questions.QuestionsInteractor
import com.hodzi.stackviewer.utils.Generator
import com.hodzi.stackviewer.utils.Shared
import com.hodzi.stackviewer.utils.Vote
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito


internal class QuestionDetailPresenterTest {
    companion object {
        lateinit var presenterEmpty: QuestionDetailPresenter
        lateinit var presenterAuth: QuestionDetailPresenter
        lateinit var view: QuestionDetailView
        lateinit var sharedEmpty: Shared
        lateinit var sharedAuth: Shared
        lateinit var observableQ: Observable<Question>

        @BeforeClass
        @JvmStatic
        fun setUp() {
            val immediate = Schedulers.trampoline()
            RxJavaPlugins.setInitIoSchedulerHandler { immediate }
            RxJavaPlugins.setInitComputationSchedulerHandler { immediate }
            RxJavaPlugins.setInitNewThreadSchedulerHandler { immediate }
            RxJavaPlugins.setInitSingleSchedulerHandler { immediate }
            RxAndroidPlugins.setInitMainThreadSchedulerHandler { immediate }

            RxJavaPlugins.reset()

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

            observableQ = Observable.create<Question> { s ->
                run {
                    s.onNext(Generator.create(Question::class.java))
                    s.onComplete()
                }
            }

            Mockito.`when`(questionsInteractor.questionDownVote(
                    ArgumentMatchers.anyInt(),
                    ArgumentMatchers.anyString()))
                    .thenReturn(observableQ)


            sharedEmpty = Mockito.mock(Shared::class.java)
            Mockito.`when`(sharedEmpty.getToken()).thenReturn("")

            sharedAuth = Mockito.mock(Shared::class.java)
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
    fun voteTest() {
        presenterAuth.vote(1, Vote.QUESTION_DOWN)
//        Mockito.verify(view).goToAuth()
        Mockito.verify(view).voiceAccepted()
    }

    @Test
    fun getQuestionsInteractor() {
    }

    @Test
    fun getShared() {
    }

}