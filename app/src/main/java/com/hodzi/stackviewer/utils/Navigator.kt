package com.hodzi.stackviewer.utils

import android.content.Context
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.model.User
import com.hodzi.stackviewer.questions.detail.QuestionDetailActivity
import com.hodzi.stackviewer.users.detail.UserDetailActivity


class Navigator{
    companion object {
        fun questionDetail(context: Context, question: Question){
            context.startActivity(QuestionDetailActivity.intent(context, question))
        }

        fun userDetail(context: Context, user: User) {
            context.startActivity(UserDetailActivity.intent(context, user))
        }
    }
}