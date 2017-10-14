package com.hodzi.stackviewer.tags

import com.hodzi.stackviewer.model.Tag
import com.hodzi.stackviewer.utils.base.BaseAdapter

class TagsAdapter(array: Array<Tag>) :
    BaseAdapter<Tag, TagsHolder>(array, TagsHolder.creator())