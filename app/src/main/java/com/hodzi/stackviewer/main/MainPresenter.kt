package com.hodzi.stackviewer.main

import android.os.Bundle
import com.hodzi.stackviewer.di.AccountManager
import com.hodzi.stackviewer.utils.base.BasePresenter

class MainPresenter(accountManager: AccountManager) : BasePresenter<MainView>(){
    override fun attach(v: MainView, bundle: Bundle?) {
        super.attach(v, bundle)
    }
}