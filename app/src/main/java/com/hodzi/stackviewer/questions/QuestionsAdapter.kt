package com.hodzi.stackviewer.questions

import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.utils.base.BaseAdapter

class QuestionsAdapter(array: Array<Question>) :
    BaseAdapter<Question, QuestionsHolder>(array, QuestionsHolder.creator()) {
}