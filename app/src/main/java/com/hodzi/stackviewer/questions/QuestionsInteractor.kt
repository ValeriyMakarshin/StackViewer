package com.hodzi.stackviewer.questions

import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.model.Question
import com.stackviewer.medium.utils.Api
import io.reactivex.Observable

class QuestionsInteractor(val api: Api){
    fun getAllQuestions() : Observable<Block<Question>> = api.getQuestions()
}