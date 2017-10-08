package com.hodzi.stackviewer.di

import android.app.Activity
import android.content.Context
import com.hodzi.stackviewer.App
import com.hodzi.stackviewer.main.MainActivity
import com.hodzi.stackviewer.main.di.MainComponent
import com.hodzi.stackviewer.questions.QuestionsFragment
import com.hodzi.stackviewer.questions.di.QuestionsComponent
import com.hodzi.stackviewer.tags.TagsFragment
import com.hodzi.stackviewer.tags.di.TagsComponent

class Injector {
    companion object {
        fun inject(app: App) {
            app.appComponent.inject(app)
        }

        fun inject(mainActivity: MainActivity) {
            getMainComponent(mainActivity).inject(mainActivity)
        }

        fun inject(questionsFragment: QuestionsFragment) {
            getQuestionsComponent(questionsFragment.context).inject(questionsFragment)
        }

        fun inject(tagsFragment: TagsFragment) {
            getTagsComponent(tagsFragment.context).inject(tagsFragment)
        }

        private fun getMainComponent(activity: Activity): MainComponent =
            (activity.applicationContext as App).mainComponent

        private fun getQuestionsComponent(context: Context): QuestionsComponent =
            (context.applicationContext as App).questionsComponent

        private fun getTagsComponent(context: Context): TagsComponent =
            (context.applicationContext as App).tagsComponent
    }
}
