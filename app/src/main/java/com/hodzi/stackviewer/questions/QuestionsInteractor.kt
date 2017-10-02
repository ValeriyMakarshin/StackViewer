package com.hodzi.stackviewer.questions

import com.stackviewer.medium.utils.Api

class QuestionsInteractor(val api: Api){
    fun getAllQuestions() {
        api.getQuestions()
    }
}