package com.hodzi.stackviewer.tags

import com.hodzi.stackviewer.core.BasePresenter

class TagsPresenter(val tagsInteractor: TagsInteractor) : BasePresenter<TagsView>() {
    override fun loadData() {
        baseObservableListDefaultError(tagsInteractor.getAllTags())
    }
}
