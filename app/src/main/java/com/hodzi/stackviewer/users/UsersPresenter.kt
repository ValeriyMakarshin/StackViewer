package com.hodzi.stackviewer.users

import android.os.Bundle
import com.hodzi.stackviewer.utils.base.BasePresenter

class UsersPresenter(val usersInteractor: UsersInteractor) : BasePresenter<UsersView>() {
    override fun loadData() {
        baseObservableListDefaultError(usersInteractor.getAllUser(), { block ->
            view?.showArray(block.items.toTypedArray())})
    }
}