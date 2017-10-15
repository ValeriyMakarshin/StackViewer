package com.hodzi.stackviewer.tags

import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.model.Tag
import com.hodzi.stackviewer.utils.Api
import io.reactivex.Observable

class TagsInteractor(val api: Api) {
    fun getAllTags() : Observable<Block<Tag>> = api.getTags()
}