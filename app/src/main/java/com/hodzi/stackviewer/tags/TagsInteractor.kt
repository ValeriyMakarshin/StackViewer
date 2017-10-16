package com.hodzi.stackviewer.tags

import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.model.Tag
import io.reactivex.Observable

interface TagsInteractor {
    fun getAllTags() : Observable<Block<Tag>>
}