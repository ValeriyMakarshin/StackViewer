package com.hodzi.stackviewer.questions.detail

import com.hodzi.stackviewer.core.BaseContract
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.utils.Vote

interface QuestionDetailContract {
    interface Navigator : BaseContract.Navigator {
        fun goToAuth()
    }

    interface View : BaseContract.View, Navigator {
        fun showQuestion(question: Question)

        fun voiceAccepted()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun vote(id: Int, vote: Vote)
    }
}
