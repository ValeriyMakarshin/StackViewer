package com.hodzi.stackviewer.questions

import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.model.Question
import io.reactivex.Observable

interface QuestionsInteractor {
    fun getAllQuestions(): Observable<Block<Question>>
}