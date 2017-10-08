package com.hodzi.stackviewer.tags.di

import com.hodzi.stackviewer.UserScope
import com.hodzi.stackviewer.tags.TagsFragment
import dagger.Subcomponent

@UserScope
@Subcomponent(modules = arrayOf(TagsModule::class))
interface TagsComponent {
    fun inject(tagsFragment: TagsFragment)
}