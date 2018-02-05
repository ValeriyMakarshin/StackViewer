package com.hodzi.stackviewer.users.di

import com.hodzi.stackviewer.StackScope
import com.hodzi.stackviewer.users.UsersInteractor
import com.hodzi.stackviewer.users.UsersInteractorImpl
import com.hodzi.stackviewer.users.UsersPresenter
import com.hodzi.stackviewer.users.detail.UserDetailPresenter
import com.hodzi.stackviewer.utils.Api
import dagger.Module
import dagger.Provides

@Module
class UsersModule {
    @Provides @StackScope
    fun provideUsersPresenter(usersInteractor: UsersInteractor): UsersPresenter =
        UsersPresenter(usersInteractor)

    @Provides @StackScope
    fun provideUserDetailPresenter(usersInteractor: UsersInteractor): UserDetailPresenter =
        UserDetailPresenter(usersInteractor)

    @Provides @StackScope
    fun provideUsersInteractor(api: Api): UsersInteractor = UsersInteractorImpl(api)
}
