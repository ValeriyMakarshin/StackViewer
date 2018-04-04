package com.hodzi.stackviewer.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.adapters.QuestionsRAdapter
import com.hodzi.stackviewer.core.BaseFragment
import com.hodzi.stackviewer.core.BaseHolder
import com.hodzi.stackviewer.core.BaseRAdapter
import com.hodzi.stackviewer.di.Injector
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.utils.Navigator
import com.hodzi.stackviewer.utils.OnClickListener
import com.hodzi.stackviewer.utils.ui.ActivityInfo
import com.hodzi.stackviewer.utils.ui.ActivityListInfo
import kotlinx.android.synthetic.main.fragment_questions.*
import kotlinx.android.synthetic.main.view_progress_bar.*
import kotlinx.android.synthetic.main.view_refresh_button.*

class QuestionsFragment : BaseFragment<QuestionContract.View, QuestionsPresenter>(),
    QuestionContract.View, OnClickListener<Question> {
    override fun onClick(item: Question) {
        context?.let { Navigator.questionDetail(it, item) }
    }

    override fun getAdapter(array: Array<*>): BaseRAdapter<*, out BaseHolder<*>>? {
        return QuestionsRAdapter(array as Array<Question>, this)
    }

    override fun getActivityInfo(): ActivityInfo = ActivityInfo(R.layout.fragment_questions,
        activityListInfo = ActivityListInfo(uiProgressBar, uiQuestionsRv,
            uiQuestionsSrl, uiRefreshBt))

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Injector.inject(this)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
