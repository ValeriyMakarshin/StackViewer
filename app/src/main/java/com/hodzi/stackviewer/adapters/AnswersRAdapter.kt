package com.hodzi.stackviewer.adapters

import com.hodzi.stackviewer.adapters.holders.AnswersHolder
import com.hodzi.stackviewer.model.Answer
import com.hodzi.stackviewer.utils.base.BaseRAdapter


class AnswersRAdapter(array: Array<Answer>) :
    BaseRAdapter<Answer, AnswersHolder>(array, AnswersHolder.creator())