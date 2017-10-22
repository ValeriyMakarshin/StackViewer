package com.hodzi.stackviewer.database

import com.hodzi.stackviewer.database.entities.Message
import com.hodzi.stackviewer.utils.base.BaseView

interface DatabaseView : BaseView {
    fun update(message: Message)
}