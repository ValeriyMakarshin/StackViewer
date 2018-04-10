package com.hodzi.stackviewer.main.di

import com.hodzi.stackviewer.StackScope
import com.hodzi.stackviewer.di.AccountManager
import com.hodzi.stackviewer.main.MainContract
import com.hodzi.stackviewer.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @Provides @StackScope
    fun provideMainPresenter(accountManager: AccountManager): MainContract.Presenter =
        MainPresenter(accountManager)

    @Provides @StackScope
    fun provideAccountManager(): AccountManager = AccountManager()

}
