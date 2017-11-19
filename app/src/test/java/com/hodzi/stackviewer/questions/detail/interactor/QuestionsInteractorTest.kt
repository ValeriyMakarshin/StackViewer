package com.hodzi.stackviewer.questions.detail.interactor

import com.hodzi.stackviewer.model.Answer
import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.questions.QuestionsInteractor
import com.hodzi.stackviewer.utils.Generator
import io.reactivex.Observable

open class QuestionsInteractorTest : QuestionsInteractor {
    override fun getAllQuestions(): Observable<Block<Question>> {
        return Observable.create { s ->
            run {
                s.onNext(Generator.create(Block::class.java) as Block<Question>)
                s.onComplete()
            }
        }

    }

    override fun getQuestionAnswers(questionId: Int): Observable<Block<Answer>> {
        return Observable.create { s ->
            run {
                s.onNext(Generator.create(Block::class.java) as Block<Answer>)
                s.onComplete()
            }
        }
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
        return Observable.create<Question> { s ->
            run {
                s.onNext(Generator.create(Question::class.java))
                s.onComplete()
            }
        }
    }
}