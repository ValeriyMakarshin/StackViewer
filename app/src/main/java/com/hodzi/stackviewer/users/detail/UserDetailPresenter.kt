package com.hodzi.stackviewer.users.detail

import com.hodzi.stackviewer.core.BasePresenter
import com.hodzi.stackviewer.users.UsersInteractor

class UserDetailPresenter(val usersInteractor: UsersInteractor) :
    BasePresenter<UserDetailContract.View>(), UserDetailContract.Presenter
