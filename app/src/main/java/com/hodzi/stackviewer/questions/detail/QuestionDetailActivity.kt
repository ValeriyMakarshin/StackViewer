package com.hodzi.stackviewer.questions.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.adapters.AnswersRAdapter
import com.hodzi.stackviewer.di.Injector
import com.hodzi.stackviewer.model.Answer
import com.hodzi.stackviewer.model.Question
import com.hodzi.stackviewer.utils.Navigator
import com.hodzi.stackviewer.utils.Vote
import com.hodzi.stackviewer.utils.base.BaseActivity
import com.hodzi.stackviewer.utils.base.BaseHolder
import com.hodzi.stackviewer.utils.base.BaseRAdapter
import com.hodzi.stackviewer.utils.ui.ActivityInfo
import com.hodzi.stackviewer.utils.ui.ActivityListInfo
import kotlinx.android.synthetic.main.activity_question_detail.*
import kotlinx.android.synthetic.main.view_progress_bar.*
import kotlinx.android.synthetic.main.view_toolbar.*

class QuestionDetailActivity : BaseActivity<QuestionDetailView, QuestionDetailPresenter>(),
    QuestionDetailView, AnswerClickListener {
    override fun onClick(item: Answer) {
    }

    companion object {
        const val EXTRA_QUESTION = "extraQuestion"

        fun intent(context: Context, question: Question): Intent {
            val bundle = Bundle()
            bundle.putSerializable(EXTRA_QUESTION, question)
            return Intent(context, QuestionDetailActivity::class.java).putExtras(bundle)
        }
    }

    override fun getActivityInfo(): ActivityInfo =
        ActivityInfo(R.layout.activity_question_detail, uiToolbar,
            activityListInfo = ActivityListInfo(uiProgressBar, uiAnswersRv))

    override fun showQuestion(question: Question) {
        uiTitleTv.text = question.title
        uiPointsTv.text = "${question.score}"
        uiTagsTv.text = question.tags.joinToString { s: String -> s + ", " }
        uiBodyWv.loadDataWithBaseURL(null, question.body, "text/html",
            "utf-8", null)

        uiArrowUpIv.setOnClickListener { vote(question.questionId, Vote.QUESTION_UP) }
        uiArrowDownIv.setOnClickListener { vote(question.questionId, Vote.QUESTION_DOWN) }
    }

    override fun getAdapter(array: Array<*>): BaseRAdapter<*, out BaseHolder<*>>? {
        return AnswersRAdapter(array as Array<Answer>, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Injector.inject(this)
        super.onCreate(savedInstanceState)
        uiAnswersRv.isNestedScrollingEnabled = false
    }

    override fun vote(id: Int, vote: Vote) {
        presenter.vote(id, vote)
    }

    override fun goToAuth() {
        Navigator.auth(this)
    }

    override fun voiceAccepted() {
        Toast.makeText(this, R.string.voice_accepted, Toast.LENGTH_SHORT).show()
    }
}
