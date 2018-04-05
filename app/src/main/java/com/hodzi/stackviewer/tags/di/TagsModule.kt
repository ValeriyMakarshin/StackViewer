package com.hodzi.stackviewer.tags.di

import com.hodzi.stackviewer.StackScope
import com.hodzi.stackviewer.tags.TagsContract
import com.hodzi.stackviewer.tags.TagsInteractor
import com.hodzi.stackviewer.tags.TagsInteractorImpl
import com.hodzi.stackviewer.tags.TagsPresenter
import com.hodzi.stackviewer.utils.Api
import dagger.Module
import dagger.Provides

@Module
class TagsModule {
    @Provides @StackScope
    fun provideTagsPresenter(tagsInteractor: TagsInteractor): TagsContract.Presenter =
        TagsPresenter(tagsInteractor)

    @Provides @StackScope
    fun provideTagsInteractor(api: Api): TagsInteractor = TagsInteractorImpl(api)
}
