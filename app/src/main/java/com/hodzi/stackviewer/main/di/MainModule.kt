package com.hodzi.stackviewer.main.di

import com.hodzi.stackviewer.UserScope
import com.hodzi.stackviewer.di.AccountManager
import com.hodzi.stackviewer.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @Provides @UserScope
    fun provideMainPresenter(accountManager: AccountManager): MainPresenter =
        MainPresenter(accountManager)

    @Provides @UserScope
    fun provideAccountManager(): AccountManager = AccountManager()

}