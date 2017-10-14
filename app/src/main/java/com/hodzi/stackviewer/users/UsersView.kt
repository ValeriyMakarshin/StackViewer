package com.hodzi.stackviewer.users

import com.hodzi.stackviewer.model.User
import com.hodzi.stackviewer.utils.base.BaseView

interface UsersView : BaseView{
    fun showArray(array: Array<User>)
}
