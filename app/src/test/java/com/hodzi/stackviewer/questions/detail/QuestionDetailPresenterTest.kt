package com.hodzi.stackviewer.questions.detail

import com.hodzi.stackviewer.model.Answer
import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.questions.QuestionsInteractor
import com.hodzi.stackviewer.utils.Shared
import com.hodzi.stackviewer.utils.Vote
import io.reactivex.Observable
import org.junit.BeforeClass
import org.junit.Test
import org.mockito.Mockito


internal class QuestionDetailPresenterTest {
    companion object {
        lateinit var presenter: QuestionDetailPresenter
        lateinit var view: QuestionDetailView

        @BeforeClass @JvmStatic
        fun setUp() {
            view = Mockito.mock(QuestionDetailView::class.java)

            val questionsInteractor: QuestionsInteractor =
                Mockito.mock(QuestionsInteractor::class.java)

            Mockito.`when`(questionsInteractor.getQuestionAnswers(0))
                .thenReturn(Observable.create<Block<Answer>> { s ->
                    run {
                        s.onNext(Block(ArrayList(),
                            false,
                            0,
                            0))
                        s.onComplete()
                    }
                })


            val shared: Shared =
                Mockito.mock(Shared::class.java)
            presenter = QuestionDetailPresenter(questionsInteractor, shared)


            Mockito.`when`(shared.getToken()).thenReturn("")

//            Mockito.`when`(view.goToAuth())
//            Mockito.doNothing().`when`(view.showQuestion(eq(any<Question>())))

            presenter.attach(view)


//            Mockito.doReturn("23").`when`(shared).getToken()


//            Mockito.`when`(questionsInteractor.questionDownVote(
//                ArgumentMatchers.anyInt(),
//                ArgumentMatchers.anyString()))
//                .thenReturn(eq(Observable.create<Question> {
//                    s ->
//                    run {
//                        s.onNext(ArgumentMatchers.any(Question::class.java))
//                        s.onComplete()
//                    }
//                }))

        }

    }
//    lateinit var

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
        presenter.vote(1, Vote.QUESTION_DOWN)
        Mockito.verify(view).goToAuth()
//        Mockito.verify(presenter).baseObservableData(Observable.just(ArgumentMatchers.any(Question::class.java)))

    }

    @Test
    fun getQuestionsInteractor() {
    }

    @Test
    fun getShared() {
    }

}