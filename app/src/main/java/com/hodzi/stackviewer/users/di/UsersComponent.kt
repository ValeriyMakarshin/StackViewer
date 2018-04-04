package com.hodzi.stackviewer.users.di

import com.hodzi.stackviewer.StackScope
import com.hodzi.stackviewer.users.UsersFragment
import com.hodzi.stackviewer.users.detail.UserDetailActivity
import dagger.Subcomponent

@StackScope
@Subcomponent(modules = [(UsersModule::class)])
interface UsersComponent {
    fun inject(usersFragment: UsersFragment)
    fun inject(userDetailActivity: UserDetailActivity)
}
