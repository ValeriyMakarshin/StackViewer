package com.hodzi.stackviewer.login.di

import com.hodzi.stackviewer.StackScope
import com.hodzi.stackviewer.login.LoginContract
import com.hodzi.stackviewer.login.LoginPresenter
import com.hodzi.stackviewer.users.UsersInteractor
import com.hodzi.stackviewer.users.UsersInteractorImpl
import com.hodzi.stackviewer.utils.Api
import com.hodzi.stackviewer.utils.Shared
import dagger.Module
import dagger.Provides

@Module
class AuthModule {
    @Provides @StackScope
    fun provideLoginPresenter(usersInteractor: UsersInteractor, shared: Shared):
        LoginContract.Presenter = LoginPresenter(usersInteractor, shared)

    @Provides @StackScope fun providesUserInteractor(api: Api): UsersInteractor =
        UsersInteractorImpl(api)
}
