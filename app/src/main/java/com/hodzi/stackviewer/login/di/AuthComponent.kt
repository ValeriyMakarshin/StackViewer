package com.hodzi.stackviewer.login.di

import com.hodzi.stackviewer.StackScope
import com.hodzi.stackviewer.login.LoginActivity
import dagger.Subcomponent

@StackScope
@Subcomponent(modules = arrayOf(AuthModule::class))
interface AuthComponent{
    fun inject(loginActivity: LoginActivity)
}