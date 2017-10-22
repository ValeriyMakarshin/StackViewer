package com.hodzi.stackviewer.adapters.holders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.model.User
import com.hodzi.stackviewer.utils.base.BaseHolder
import kotlinx.android.synthetic.main.item_user_preview.view.*

class UsersHolder(itemView: View) : BaseHolder<User>(itemView) {
    companion object {
        fun creator(): (ViewGroup?) -> UsersHolder =
            { viewGroup ->
                UsersHolder(LayoutInflater.from(viewGroup?.context)
                    .inflate(R.layout.item_user_preview, viewGroup, false))
            }
    }

    override fun onDraw(item: User) {
        itemView.uiNameTv.text = item.displayName
        itemView.uiLocationTv.text = item.location
        itemView.uiReputationTv.text = item.reputation.toString()

        Glide.with(itemView.context)
            .load(item.profileImage)
            .into(itemView.uiPhotoIv)
    }
}