package com.hodzi.stackviewer.tags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.adapters.TagsRRAdapter
import com.hodzi.stackviewer.di.Injector
import com.hodzi.stackviewer.model.Tag
import com.hodzi.stackviewer.utils.base.BaseFragment
import com.hodzi.stackviewer.utils.ui.ActivityInfo
import com.hodzi.stackviewer.utils.ui.ActivityListInfo
import kotlinx.android.synthetic.main.fragment_tags.*
import kotlinx.android.synthetic.main.view_progress_bar.*

class TagsFragment : BaseFragment<TagsView, TagsPresenter>(), TagsView {
    override fun showArray(array: Array<Tag>) {
        uiTagsRv.adapter = TagsRRAdapter(array)
    }

    override fun getActivityInfo(): ActivityInfo = ActivityInfo(R.layout.fragment_tags,
        activityListInfo = ActivityListInfo(uiProgressBar, uiTagsRv))

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Injector.inject(this)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

}