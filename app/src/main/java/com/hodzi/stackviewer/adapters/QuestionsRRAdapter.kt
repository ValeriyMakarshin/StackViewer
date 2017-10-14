package com.hodzi.stackviewer.adapters

import com.hodzi.stackviewer.adapters.holders.QuestionsHolder
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.utils.base.BaseRAdapter

class QuestionsRRAdapter(array: Array<Question>) :
    BaseRAdapter<Question, QuestionsHolder>(array, QuestionsHolder.creator()) {
}