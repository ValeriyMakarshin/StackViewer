package com.hodzi.stackviewer.login

import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.core.BasePresenter
import com.hodzi.stackviewer.users.UsersInteractor
import com.hodzi.stackviewer.utils.Shared
import com.hodzi.stackviewer.utils.Strings

class LoginPresenter(val usersInteractor: UsersInteractor, val shared: Shared) :
    BasePresenter<LoginContract.View>(), LoginContract.Presenter {
    companion object {
        const val STATE_KEY: String = "state"
        const val TOKEN_KEY: String = "access_token"

        var state: String = Strings.EMPTY_STRING
    }

    override fun checkUrl(redirectUrl: String) {
        val data: Map<String, String> = Strings.parseUrlArgs(redirectUrl)
        if (data[STATE_KEY].equals(state)) {
            shared.saveToken(data[TOKEN_KEY])
            view?.finish()
        } else {
            view?.showError(R.string.error_obsolete)
        }
    }
}
