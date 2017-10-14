package com.hodzi.stackviewer.adapters.holders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.model.User
import com.hodzi.stackviewer.utils.base.BaseHolder

class UsersHolder(itemView: View) : BaseHolder<User>(itemView) {
    companion object {
        fun creator() : (ViewGroup?) -> UsersHolder =
            { viewGroup ->
                UsersHolder(LayoutInflater.from(viewGroup?.context)
                    .inflate(R.layout.item_tag_preview, viewGroup, false))
            }
    }

    override fun onDraw(item: User) {

    }
}