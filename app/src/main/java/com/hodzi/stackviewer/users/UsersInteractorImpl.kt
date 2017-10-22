package com.hodzi.stackviewer.users

import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.model.User
import com.hodzi.stackviewer.utils.Api
import io.reactivex.Observable

class UsersInteractorImpl(val api: Api) :UsersInteractor{
    override fun getAllUser(): Observable<Block<User>> = api.getUsers()
}