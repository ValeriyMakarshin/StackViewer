package com.hodzi.stackviewer.questions.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.di.Injector
import com.hodzi.stackviewer.model.Answer
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.utils.base.BaseActivity
import com.hodzi.stackviewer.utils.ui.ActivityInfo
import com.hodzi.stackviewer.utils.ui.ActivityListInfo
import kotlinx.android.synthetic.main.view_progress_bar.*
import kotlinx.android.synthetic.main.view_toolbar.*

class QuestionDetailActivity : BaseActivity<QuestionDetailView, QuestionDetailPresenter>(),
    QuestionDetailView {
    companion object {
        const val EXTRA_QUESTION = "extraQuestion"

        fun intent(context: Context, question: Question): Intent {
            val bundle = Bundle()
            bundle.putSerializable(EXTRA_QUESTION, question)
            return Intent(context, QuestionDetailActivity::class.java).putExtras(bundle)
        }
    }

    override fun showArray(array: Array<Answer>) {
//        uiQuestionsRv.adapter = QuestionsRRAdapter(array, this)
    }

    override fun getActivityInfo(): ActivityInfo =
        ActivityInfo(R.layout.activity_question_detail, uiToolbar,
            activityListInfo = ActivityListInfo(uiProgressBar))


    override fun onCreate(savedInstanceState: Bundle?) {
        Injector.inject(this)
        super.onCreate(savedInstanceState)
    }

}