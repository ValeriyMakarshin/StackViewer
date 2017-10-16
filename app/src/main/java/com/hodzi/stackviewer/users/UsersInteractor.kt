package com.hodzi.stackviewer.users

import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.model.User
import io.reactivex.Observable

interface UsersInteractor {
    fun getAllUser(): Observable<Block<User>>
}
