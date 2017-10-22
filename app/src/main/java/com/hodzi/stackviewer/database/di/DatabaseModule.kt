package com.hodzi.stackviewer.database.di

import com.hodzi.stackviewer.StackScope
import com.hodzi.stackviewer.database.DatabasePresenter
import com.hodzi.stackviewer.database.DatabaseWorker
import com.hodzi.stackviewer.database.DatabaseWorkerImpl
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {
    @Provides @StackScope
    fun provideDatabasePresenter(databaseWorker: DatabaseWorker): DatabasePresenter =
        DatabasePresenter(databaseWorker)

    @Provides @StackScope
    fun provideDatabaseWorker(): DatabaseWorker = DatabaseWorkerImpl()

}