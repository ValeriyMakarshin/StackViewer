package com.hodzi.stackviewer.users

import com.hodzi.stackviewer.core.BasePresenter

class UsersPresenter(val usersInteractor: UsersInteractor) :
    BasePresenter<UsersContract.View>(), UsersContract.Presenter {

    override fun loadData() {
        baseObservableListDefaultError(usersInteractor.getAllUser())
    }
}
