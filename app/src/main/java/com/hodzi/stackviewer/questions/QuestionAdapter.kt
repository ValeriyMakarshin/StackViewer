package com.hodzi.stackviewer.questions

import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.utils.base.BaseAdapter

class QuestionAdapter(array: Array<Question>) :
    BaseAdapter<Question, QuestionHolder>(array, QuestionHolder.creator()) {
}