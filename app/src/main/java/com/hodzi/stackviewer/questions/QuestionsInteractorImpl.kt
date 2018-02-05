package com.hodzi.stackviewer.questions

import com.hodzi.stackviewer.model.Answer
import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.utils.Api
import io.reactivex.Observable

class QuestionsInteractorImpl(val api: Api) : QuestionsInteractor {
    override fun getQuestionAnswers(questionId: Int): Observable<Block<Answer>> =
        api.getAnswers(questionId)

    override fun getAllQuestions(): Observable<Block<Question>> = api.getQuestions()

    override fun answerUpVote(answerId: Int, token: String): Observable<Answer> =
        api.answersUpVote(answerId, token)

    override fun answerDownVote(answerId: Int, token: String): Observable<Answer> =
        api.answersDownVote(answerId, token)

    override fun questionUpVote(questionId: Int, token: String): Observable<Question> =
        api.questionUpVote(questionId, token)

    override fun questionDownVote(questionId: Int, token: String): Observable<Question> =
        api.questionDownVote(questionId, token)
}
