package com.hodzi.stackviewer.users.detail

import com.hodzi.stackviewer.core.BaseContract

interface UserDetailContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>
}