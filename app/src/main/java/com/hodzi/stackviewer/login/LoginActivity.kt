package com.hodzi.stackviewer.login

import android.os.Bundle
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.core.BaseActivity
import com.hodzi.stackviewer.di.Injector
import com.hodzi.stackviewer.utils.ui.ActivityInfo

class LoginActivity : BaseActivity<LoginContract.View, LoginContract.Presenter>(),
    LoginContract.View {

    override fun finish() {
    }

    override fun getActivityInfo(): ActivityInfo = ActivityInfo(R.layout.activity_login)

    override fun onCreate(savedInstanceState: Bundle?) {
        Injector.inject(this)
        super.onCreate(savedInstanceState)

        presenter.checkUrl(intent?.data.toString())
    }
}
