package com.hodzi.stackviewer.di

import android.app.Application
import android.content.Context
import com.hodzi.stackviewer.utils.Shared
import com.hodzi.stackviewer.utils.SharedImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides @Singleton
    fun provideApplication(): Context = application

    @Provides @Singleton
    fun provideShared(context: Context): Shared =
            SharedImpl(context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE))

}
