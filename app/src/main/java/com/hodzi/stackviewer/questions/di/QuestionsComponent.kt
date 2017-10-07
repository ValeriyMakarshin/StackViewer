package com.hodzi.stackviewer.questions.di

import android.app.Activity
import com.hodzi.stackviewer.UserScope
import dagger.Subcomponent

@UserScope
@Subcomponent(modules = arrayOf(QuestionsModule::class))
interface QuestionsComponent {
    fun inject(activity: Activity)
}