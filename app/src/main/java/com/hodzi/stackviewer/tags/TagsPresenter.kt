package com.hodzi.stackviewer.tags

import com.hodzi.stackviewer.utils.base.BasePresenter

class TagsPresenter(val tagsInteractor: TagsInteractor) : BasePresenter<TagsView>() {
    override fun loadData() {
        baseObservableListDefaultError(tagsInteractor.getAllTags(), { block ->
            view?.showArray(block.items.toTypedArray())
        })
    }
}
