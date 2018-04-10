package com.hodzi.stackviewer.main

import com.hodzi.stackviewer.core.BaseContract

interface MainContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>
}
