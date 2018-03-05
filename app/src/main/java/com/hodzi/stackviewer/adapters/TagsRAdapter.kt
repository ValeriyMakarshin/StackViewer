package com.hodzi.stackviewer.adapters

import com.hodzi.stackviewer.adapters.holders.TagsHolder
import com.hodzi.stackviewer.model.Tag
import com.hodzi.stackviewer.core.BaseRAdapter

class TagsRAdapter(array: Array<Tag>) :
    BaseRAdapter<Tag, TagsHolder>(array, TagsHolder.creator())
