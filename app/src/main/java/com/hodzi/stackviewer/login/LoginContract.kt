package com.hodzi.stackviewer.login

import com.hodzi.stackviewer.core.BaseContract

interface LoginContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View> {
        fun checkUrl(redirectUrl: String)
    }
}
