package com.hodzi.stackviewer.users.di

import com.hodzi.stackviewer.StackScope
import com.hodzi.stackviewer.users.UsersContract
import com.hodzi.stackviewer.users.UsersInteractor
import com.hodzi.stackviewer.users.UsersInteractorImpl
import com.hodzi.stackviewer.users.UsersPresenter
import com.hodzi.stackviewer.users.detail.UserDetailContract
import com.hodzi.stackviewer.users.detail.UserDetailPresenter
import com.hodzi.stackviewer.utils.Api
import dagger.Module
import dagger.Provides

@Module
class UsersModule {
    @Provides @StackScope
    fun provideUsersPresenter(usersInteractor: UsersInteractor):
        UsersContract.Presenter = UsersPresenter(usersInteractor)

    @Provides @StackScope
    fun provideUserDetailPresenter(usersInteractor: UsersInteractor):
        UserDetailContract.Presenter = UserDetailPresenter(usersInteractor)

    @Provides @StackScope
    fun provideUsersInteractor(api: Api): UsersInteractor = UsersInteractorImpl(api)
}
