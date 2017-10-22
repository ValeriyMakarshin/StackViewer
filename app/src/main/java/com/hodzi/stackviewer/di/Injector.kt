package com.hodzi.stackviewer.di

import android.app.Activity
import android.content.Context
import com.hodzi.stackviewer.App
import com.hodzi.stackviewer.database.DatabaseActivity
import com.hodzi.stackviewer.database.di.DatabaseComponent
import com.hodzi.stackviewer.login.LoginActivity
import com.hodzi.stackviewer.login.di.AuthComponent
import com.hodzi.stackviewer.main.MainActivity
import com.hodzi.stackviewer.main.di.MainComponent
import com.hodzi.stackviewer.questions.QuestionsFragment
import com.hodzi.stackviewer.questions.detail.QuestionDetailActivity
import com.hodzi.stackviewer.questions.di.QuestionsComponent
import com.hodzi.stackviewer.tags.TagsFragment
import com.hodzi.stackviewer.tags.di.TagsComponent
import com.hodzi.stackviewer.users.UsersFragment
import com.hodzi.stackviewer.users.detail.UserDetailActivity
import com.hodzi.stackviewer.users.di.UsersComponent

class Injector {
    companion object {
        fun inject(app: App) {
            app.appComponent.inject(app)
        }

        fun inject(loginActivity: LoginActivity) {
            getAuthComponent(loginActivity).inject(loginActivity)
        }

        fun inject(mainActivity: MainActivity) {
            getMainComponent(mainActivity).inject(mainActivity)
        }

        fun inject(questionsFragment: QuestionsFragment) {
            getQuestionsComponent(questionsFragment.context).inject(questionsFragment)
        }

        fun inject(questionDetailActivity: QuestionDetailActivity) {
            getQuestionsComponent(questionDetailActivity).inject(questionDetailActivity)
        }

        fun inject(tagsFragment: TagsFragment) {
            getTagsComponent(tagsFragment.context).inject(tagsFragment)
        }

        fun inject(usersFragment: UsersFragment) {
            getUsersComponent(usersFragment.context).inject(usersFragment)
        }

        fun inject(userDetailActivity: UserDetailActivity) {
            getUsersComponent(userDetailActivity).inject(userDetailActivity)
        }

        fun inject(databaseActivity: DatabaseActivity) {
            getDatabaseComponent(databaseActivity).inject(databaseActivity)
        }

        private fun getAuthComponent(activity: Activity): AuthComponent =
            (activity.applicationContext as App).authComponent

        private fun getMainComponent(activity: Activity): MainComponent =
            (activity.applicationContext as App).mainComponent

        private fun getQuestionsComponent(context: Context): QuestionsComponent =
            (context.applicationContext as App).questionsComponent

        private fun getTagsComponent(context: Context): TagsComponent =
            (context.applicationContext as App).tagsComponent

        private fun getUsersComponent(context: Context): UsersComponent =
            (context.applicationContext as App).usersComponent

        private fun getDatabaseComponent(context: Context): DatabaseComponent =
            (context.applicationContext as App).databaseComponent

    }
}
