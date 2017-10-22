package com.hodzi.stackviewer.database.di

import com.hodzi.stackviewer.StackScope
import com.hodzi.stackviewer.database.DatabaseActivity
import dagger.Subcomponent

@StackScope
@Subcomponent(modules = arrayOf(DatabaseModule::class))
interface DatabaseComponent {
    fun inject(databaseActivity: DatabaseActivity)
}