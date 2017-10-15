package com.hodzi.stackviewer.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hodzi.stackviewer.R
import kotlinx.android.synthetic.main.activity_login.*



class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

//        uiLoginWv
        uiLoginWv.loadUrl("https://stackexchange.com/oauth/dialog?" +
            "client_id=11030&" +
            "scope=read_inbox,no_expiry,write_access,private_info&" +
            "redirect_uri=https://stackexchange.com/oauth/login_success&" +
            "state=123")


//            "lf3eZ5aWJWanJqtpxsOPXg(("
    }
}