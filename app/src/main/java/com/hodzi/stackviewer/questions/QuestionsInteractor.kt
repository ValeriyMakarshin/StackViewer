package com.hodzi.stackviewer.questions

import com.hodzi.stackviewer.model.Answer
import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.model.Question
import io.reactivex.Observable

interface QuestionsInteractor {
    fun getAllQuestions(): Observable<Block<Question>>

    fun getQuestionAnswers(questionId: Int): Observable<Block<Answer>>

    fun answerUpVote(answerId: Int, token: String): Observable<Answer>

    fun answerDownVote(answerId: Int, token: String): Observable<Answer>

    fun questionUpVote(questionId: Int, token: String): Observable<Question>

    fun questionDownVote(questionId: Int, token: String): Observable<Question>

}