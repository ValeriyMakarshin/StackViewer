package com.hodzi.stackviewer.users

import com.hodzi.stackviewer.core.BaseContract

interface UsersContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>

}