package com.hodzi.stackviewer.questions

import com.hodzi.stackviewer.model.Data
import com.hodzi.stackviewer.utils.base.BaseView

interface QuestionsView : BaseView{
    fun showArray(array: Array<Data>)
}