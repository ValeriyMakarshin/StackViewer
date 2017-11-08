package com.hodzi.stackviewer.questions.detail.interactor

import com.hodzi.stackviewer.model.Answer
import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.model.Owner
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.questions.QuestionsInteractor
import io.reactivex.Observable
import java.util.*

class QuestionsInteractorTest : QuestionsInteractor {
    override fun getAllQuestions(): Observable<Block<Question>> {
        return Observable.create { s ->
            run {
                s.onNext(Block(
                    Arrays.asList(
                        Question(
                            Arrays.asList("Java", "Android"),
                            Owner(32,
                                12,
                                "user",
                                3,
                                "",
                                "John Smith",
                                ""),
                            true,
                            34,
                            2,
                            3,
                            5,
                            2,
                            3,
                            3,
                            3,
                            3,
                            3,
                            "",
                            "titleTest",
                            "bodyTest")),
                    true,
                    1,
                    1)
                )
                s.onComplete()
            }
        }

    }

    override fun getQuestionAnswers(questionId: Int): Observable<Block<Answer>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun answerUpVote(answerId: Int, token: String): Observable<Answer> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun answerDownVote(answerId: Int, token: String): Observable<Answer> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun questionUpVote(questionId: Int, token: String): Observable<Question> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun questionDownVote(questionId: Int, token: String): Observable<Question> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}