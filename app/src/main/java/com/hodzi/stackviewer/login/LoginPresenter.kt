package com.hodzi.stackviewer.login

import com.hodzi.stackviewer.users.UsersInteractor
import com.hodzi.stackviewer.utils.Shared
import com.hodzi.stackviewer.utils.base.BasePresenter

class LoginPresenter(val usersInteractor: UsersInteractor, val shared: Shared) :
    BasePresenter<LoginView>() {
}