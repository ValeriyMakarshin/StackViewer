package com.hodzi.stackviewer.tags.di

import com.hodzi.stackviewer.StackScope
import com.hodzi.stackviewer.tags.TagsFragment
import dagger.Subcomponent

@StackScope
@Subcomponent(modules = [(TagsModule::class)])
interface TagsComponent {
    fun inject(tagsFragment: TagsFragment)
}
