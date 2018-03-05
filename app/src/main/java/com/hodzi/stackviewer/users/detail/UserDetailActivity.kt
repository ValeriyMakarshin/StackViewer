package com.hodzi.stackviewer.users.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.di.Injector
import com.hodzi.stackviewer.model.User
import com.hodzi.stackviewer.core.BaseActivity
import com.hodzi.stackviewer.utils.ui.ActivityInfo


class UserDetailActivity : BaseActivity<UserDetailView, UserDetailPresenter>(), UserDetailView {
    companion object {
        const val EXTRA_USER_ID = "extraUser"

        fun intent(context: Context, user: User): Intent {
            val bundle: Bundle = Bundle()
            bundle.putInt(EXTRA_USER_ID, user.accountId)
            return Intent(context, UserDetailActivity::class.java).putExtras(bundle)
        }
    }

    override fun getActivityInfo(): ActivityInfo = ActivityInfo(R.layout.activity_user_datail)

    override fun onCreate(savedInstanceState: Bundle?) {
        Injector.inject(this)
        super.onCreate(savedInstanceState)
    }
}
