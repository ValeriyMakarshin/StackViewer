package com.hodzi.stackviewer.main.di

import com.hodzi.stackviewer.UserScope
import com.hodzi.stackviewer.main.MainActivity
import dagger.Subcomponent

@UserScope
@Subcomponent(modules = arrayOf(MainModule::class))
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}