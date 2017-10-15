package com.hodzi.stackviewer.utils

import android.content.Context
import android.support.v4.content.ContextCompat.startActivity
import com.hodzi.stackviewer.model.User
import com.hodzi.stackviewer.users.detail.UserDetailActivity


class Navigator{
    companion object {
        fun cameraDetails(context: Context, user: User) {
            context.startActivity(UserDetailActivity.intent(context, user))
        }

    }
}