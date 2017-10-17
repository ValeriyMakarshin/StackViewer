package com.hodzi.stackviewer.questions

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.adapters.QuestionsRRAdapter
import com.hodzi.stackviewer.di.Injector
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.utils.OnClickListener
import com.hodzi.stackviewer.utils.base.BaseFragment
import com.hodzi.stackviewer.utils.ui.ActivityInfo
import com.hodzi.stackviewer.utils.ui.ActivityListInfo
import kotlinx.android.synthetic.main.fragment_questions.*
import kotlinx.android.synthetic.main.view_progress_bar.*

class QuestionsFragment : BaseFragment<QuestionsView, QuestionsPresenter>(), QuestionsView,
    OnClickListener<Question>{
    override fun onClick(item: Question) {
        Log.d("132", "1234")
    }


    override fun showArray(array: Array<Question>) {
        uiQuestionsRv.adapter = QuestionsRRAdapter(array, this)
    }

    override fun getActivityInfo(): ActivityInfo = ActivityInfo(R.layout.fragment_questions,
        activityListInfo = ActivityListInfo(uiProgressBar, uiQuestionsRv))

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        Injector.inject(this)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}