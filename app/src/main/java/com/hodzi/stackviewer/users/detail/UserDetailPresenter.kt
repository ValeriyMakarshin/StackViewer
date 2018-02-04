package com.hodzi.stackviewer.users.detail

import com.hodzi.stackviewer.users.UsersInteractor
import com.hodzi.stackviewer.utils.base.BasePresenter

class UserDetailPresenter(val usersInteractor: UsersInteractor) : BasePresenter<UserDetailView>()