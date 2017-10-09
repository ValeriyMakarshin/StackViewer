package com.hodzi.stackviewer.questions

import com.hodzi.stackviewer.model.Block
import com.stackviewer.medium.utils.Api
import io.reactivex.Observable

class QuestionsInteractor(val api: Api){
    fun getAllQuestions() : Observable<Block> = api.getQuestions()
}