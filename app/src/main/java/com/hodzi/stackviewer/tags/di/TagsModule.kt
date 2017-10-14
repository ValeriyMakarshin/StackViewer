package com.hodzi.stackviewer.tags.di

import com.hodzi.stackviewer.UserScope
import com.hodzi.stackviewer.tags.TagsInteractor
import com.hodzi.stackviewer.tags.TagsPresenter
import com.stackviewer.medium.utils.Api
import dagger.Module
import dagger.Provides

@Module
class TagsModule() {
    @Provides @UserScope
    fun provideTagsPresenter(tagsInteractor: TagsInteractor) : TagsPresenter =
        TagsPresenter(tagsInteractor)

    @Provides @UserScope
    fun provideTagsInteractor(api: Api) : TagsInteractor = TagsInteractor(api)
}