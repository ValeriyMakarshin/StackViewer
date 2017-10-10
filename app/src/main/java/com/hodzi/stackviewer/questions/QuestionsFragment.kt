package com.hodzi.stackviewer.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.di.Injector
import com.hodzi.stackviewer.utils.base.BaseFragment
import com.hodzi.stackviewer.utils.ui.ActivityInfo

class QuestionsFragment: BaseFragment<QuestionsView, QuestionsPresenter>(), QuestionsView {
    override fun getActivityInfo(): ActivityInfo = ActivityInfo(R.layout.fragment_questions)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Injector.inject(this)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}