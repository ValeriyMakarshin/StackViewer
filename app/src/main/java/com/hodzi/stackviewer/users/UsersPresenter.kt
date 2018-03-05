package com.hodzi.stackviewer.users

import com.hodzi.stackviewer.core.BasePresenter

class UsersPresenter(val usersInteractor: UsersInteractor) : BasePresenter<UsersView>() {
    override fun loadData() {
        baseObservableListDefaultError(usersInteractor.getAllUser())
    }
}
