package com.hodzi.stackviewer.tags

import com.hodzi.stackviewer.model.Tag
import com.hodzi.stackviewer.utils.base.BaseView

interface TagsView : BaseView {
    fun showArray(array: Array<Tag>)
}