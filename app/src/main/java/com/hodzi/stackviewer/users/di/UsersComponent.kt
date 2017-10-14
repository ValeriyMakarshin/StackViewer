package com.hodzi.stackviewer.users.di

import com.hodzi.stackviewer.StackScope
import com.hodzi.stackviewer.users.UsersFragment
import dagger.Subcomponent

@StackScope
@Subcomponent(modules = arrayOf(UsersModule::class))
interface UsersComponent {
    fun inject(usersFragment: UsersFragment)
}