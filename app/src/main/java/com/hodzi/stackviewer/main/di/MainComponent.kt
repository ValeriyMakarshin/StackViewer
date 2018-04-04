package com.hodzi.stackviewer.main.di

import com.hodzi.stackviewer.StackScope
import com.hodzi.stackviewer.main.MainActivity
import dagger.Subcomponent

@StackScope
@Subcomponent(modules = [(MainModule::class)])
interface MainComponent {
    fun inject(mainActivity: MainActivity)
}
