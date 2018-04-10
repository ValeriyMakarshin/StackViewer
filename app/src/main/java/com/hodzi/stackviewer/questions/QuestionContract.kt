package com.hodzi.stackviewer.questions

import com.hodzi.stackviewer.core.BaseContract

interface QuestionContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>
}
