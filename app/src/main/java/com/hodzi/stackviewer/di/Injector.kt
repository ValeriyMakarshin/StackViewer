package com.hodzi.stackviewer.di

import com.hodzi.stackviewer.App
import com.hodzi.stackviewer.main.MainActivity
import com.hodzi.stackviewer.main.di.MainComponent
import com.hodzi.stackviewer.questions.QuestionsActivity
import com.hodzi.stackviewer.questions.di.QuestionsComponent

class Injector {
    companion object {
        fun inject(app: App) {
            app.appComponent.inject(app)
        }

        fun inject(mainActivity: MainActivity) {
            getMainComponent(mainActivity).inject(mainActivity)
        }

        fun inject(questionsActivity: QuestionsActivity) {
            getQuestionsComponent(questionsActivity).inject(questionsActivity)
        }

        private fun getMainComponent(mainActivity: MainActivity): MainComponent =
            (mainActivity.applicationContext as App).mainComponent

        private fun getQuestionsComponent(activity: QuestionsActivity): QuestionsComponent =
            (activity.applicationContext as App).questionsComponent
    }
}
