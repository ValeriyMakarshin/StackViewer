package com.hodzi.stackviewer.tags

import android.os.Bundle
import com.hodzi.stackviewer.utils.base.BasePresenter

class TagsPresenter(val tagsInteractor: TagsInteractor) : BasePresenter<TagsView>(){
    override fun attach(v: TagsView, bundle: Bundle?) {
        super.attach(v, bundle)

        baseObservableListDefaultError(tagsInteractor.getAllTags(), { block ->
            view?.showArray(block.items.toTypedArray())})
    }
}