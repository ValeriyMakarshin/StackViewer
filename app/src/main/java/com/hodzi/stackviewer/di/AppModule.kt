package com.hodzi.stackviewer.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Context = application

    @Provides
    @Singleton
    fun provideSharedPrefs(context: Context): SharedPreferences =
            context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)

}