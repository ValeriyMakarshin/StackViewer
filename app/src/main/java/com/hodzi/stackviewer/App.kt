package com.hodzi.stackviewer

import android.app.Application
import com.facebook.stetho.Stetho
import com.hodzi.stackviewer.di.*
import com.hodzi.stackviewer.login.di.AuthComponent
import com.hodzi.stackviewer.login.di.AuthModule
import com.hodzi.stackviewer.main.di.MainComponent
import com.hodzi.stackviewer.main.di.MainModule
import com.hodzi.stackviewer.questions.di.QuestionsComponent
import com.hodzi.stackviewer.questions.di.QuestionsModule
import com.hodzi.stackviewer.tags.di.TagsComponent
import com.hodzi.stackviewer.tags.di.TagsModule
import com.hodzi.stackviewer.users.di.UsersComponent
import com.hodzi.stackviewer.users.di.UsersModule

class App : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .netModule(NetModule())
            .appModule(AppModule(this))
            .build()
    }

    val mainComponent: MainComponent by lazy {
        appComponent.plus(MainModule())
    }

    val authComponent: AuthComponent by lazy {
        appComponent.plus(AuthModule())
    }

    val questionsComponent: QuestionsComponent by lazy {
        appComponent.plus(QuestionsModule())
    }

    val tagsComponent: TagsComponent by lazy {
        appComponent.plus(TagsModule())
    }

    val usersComponent: UsersComponent by lazy {
        appComponent.plus(UsersModule())
    }

    override fun onCreate() {
        super.onCreate()
        Injector.inject(this)
        NetUtils.init(this)


        Stetho.initialize(
            Stetho.newInitializerBuilder(this)
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .build())
    }

}

