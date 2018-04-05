package com.hodzi.stackviewer.main

import com.hodzi.stackviewer.core.BasePresenter
import com.hodzi.stackviewer.di.AccountManager

class MainPresenter(accountManager: AccountManager) :
    BasePresenter<MainContract.View>(), MainContract.Presenter
