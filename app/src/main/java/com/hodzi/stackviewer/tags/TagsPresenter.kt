package com.hodzi.stackviewer.tags

import com.hodzi.stackviewer.core.BasePresenter
class TagsPresenter(val tagsInteractor: TagsInteractor) :
    BasePresenter<TagsContract.View>(), TagsContract.Presenter {
    override fun loadData() {
        baseObservableListDefaultError(tagsInteractor.getAllTags())
    }
}

