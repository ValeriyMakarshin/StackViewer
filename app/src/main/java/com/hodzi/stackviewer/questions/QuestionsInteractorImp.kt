package com.hodzi.stackviewer.questions

import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.utils.Api
import io.reactivex.Observable

class QuestionsInteractorImp(val api: Api) : QuestionsInteractor {
    override fun getAllQuestions(): Observable<Block<Question>> = api.getQuestions()
}