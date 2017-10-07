package com.hodzi.stackviewer.di

import android.app.Activity
import com.hodzi.stackviewer.App
import com.hodzi.stackviewer.main.MainActivity
import com.hodzi.stackviewer.main.di.MainComponent
import com.hodzi.stackviewer.questions.QuestionsFragment
import com.hodzi.stackviewer.questions.di.QuestionsComponent

class Injector {
    companion object {
        fun inject(app: App) {
            app.appComponent.inject(app)
        }

        fun inject(mainActivity: MainActivity) {
            getMainComponent(mainActivity).inject(mainActivity)
        }

        fun inject(questionsFragment: QuestionsFragment) {
            getQuestionsComponent(questionsFragment.activity).inject(questionsFragment.activity)
        }

        private fun getMainComponent(activity: Activity): MainComponent =
            (activity.applicationContext as App).mainComponent

        private fun getQuestionsComponent(activity: Activity): QuestionsComponent =
            (activity.applicationContext as App).questionsComponent
    }
}
