package com.hodzi.stackviewer.users

import com.hodzi.stackviewer.utils.base.BasePresenter

class UsersPresenter(val usersInteractor: UsersInteractor) : BasePresenter<UsersView>() {
    override fun loadData() {
        baseObservableListDefaultError(usersInteractor.getAllUser())
    }
}
