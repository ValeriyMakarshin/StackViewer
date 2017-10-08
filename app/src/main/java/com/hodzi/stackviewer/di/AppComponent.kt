package com.hodzi.stackviewer.di

import com.hodzi.stackviewer.App
import com.hodzi.stackviewer.main.di.MainComponent
import com.hodzi.stackviewer.main.di.MainModule
import com.hodzi.stackviewer.questions.di.QuestionsComponent
import com.hodzi.stackviewer.questions.di.QuestionsModule
import com.hodzi.stackviewer.tags.di.TagsComponent
import com.hodzi.stackviewer.tags.di.TagsModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetModule::class))
interface AppComponent {

    fun inject(app: App)

    fun plus(mainModule: MainModule): MainComponent

    fun plus(questionsModule: QuestionsModule): QuestionsComponent

    fun plus(tagsModule: TagsModule): TagsComponent
}
