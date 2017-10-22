package com.hodzi.stackviewer.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.hodzi.stackviewer.login.LoginPresenter
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.model.User
import com.hodzi.stackviewer.questions.detail.QuestionDetailActivity
import com.hodzi.stackviewer.users.detail.UserDetailActivity


class Navigator{
    companion object {

        fun auth(context: Context){
            val state = System.currentTimeMillis().toString(16)
            LoginPresenter.state = state

//            context.startActivity(Intent(context, LoginActivity::class.java))

            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(
                "https://stackexchange.com/oauth/dialog?" +
                "client_id=11030&" +
                "scope=read_inbox,no_expiry,write_access,private_info&" +
                "redirect_uri=https://stackexchange.com/oauth/login_success&" +
                "state=$state")))
        }

        fun questionDetail(context: Context, question: Question){
            context.startActivity(QuestionDetailActivity.intent(context, question))
        }

        fun userDetail(context: Context, user: User) {
            context.startActivity(UserDetailActivity.intent(context, user))
        }
    }
}