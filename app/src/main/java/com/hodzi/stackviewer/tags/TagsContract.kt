package com.hodzi.stackviewer.tags

import com.hodzi.stackviewer.core.BaseContract

interface TagsContract {
    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>
}
