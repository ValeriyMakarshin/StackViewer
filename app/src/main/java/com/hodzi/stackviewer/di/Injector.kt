package com.hodzi.stackviewer.di

import com.hodzi.stackviewer.App
import com.hodzi.stackviewer.questions.QuestionsActivity
import com.hodzi.stackviewer.questions.di.QuestionsComponent

class Injector {
    companion object {
        fun inject(app: App) {
            app.appComponent.inject(app)
        }

        fun inject(questionsActivity: QuestionsActivity) {
            getQuestionsComponent(questionsActivity)?.inject(questionsActivity)
        }

        private fun getQuestionsComponent(activity: QuestionsActivity): QuestionsComponent? {
            return (activity.applicationContext as App).questionsComponent
        }
    }
}
