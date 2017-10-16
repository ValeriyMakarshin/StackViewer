package com.hodzi.stackviewer.login

import android.os.Bundle
import android.os.PersistableBundle
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.di.Injector
import com.hodzi.stackviewer.utils.base.BaseActivity
import com.hodzi.stackviewer.utils.ui.ActivityInfo


class LoginActivity : BaseActivity<LoginView, LoginPresenter>(), LoginView {
    override fun getActivityInfo(): ActivityInfo = ActivityInfo(R.layout.activity_login)

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        Injector.inject(this)
        super.onCreate(savedInstanceState, persistentState)
    }

    //        uiLoginWv.loadUrl("https://stackexchange.com/oauth/dialog?" +
//            "client_id=11030&" +
//            "scope=read_inbox,no_expiry,write_access,private_info&" +
//            "redirect_uri=https://stackexchange.com/oauth/login_success&" +
//            "state=123")
//

//            "lf3eZ5aWJWanJqtpxsOPXg(("
}