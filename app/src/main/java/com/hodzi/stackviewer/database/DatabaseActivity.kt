package com.hodzi.stackviewer.database

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.database.entities.Message
import com.hodzi.stackviewer.di.Injector
import com.hodzi.stackviewer.utils.base.BaseActivity
import com.hodzi.stackviewer.utils.ui.ActivityInfo
import com.hodzi.stackviewer.utils.ui.ActivityListInfo
import kotlinx.android.synthetic.main.activity_database_example.*
import kotlinx.android.synthetic.main.view_toolbar.*

class DatabaseActivity : BaseActivity<DatabaseView, DatabasePresenter>(), DatabaseView {
    override fun update(message: Message) {
        (uiMessageRv.adapter as MessageRAdapter).array.plus(message)
        (uiMessageRv.adapter as MessageRAdapter)
            .notifyItemInserted((uiMessageRv.adapter as MessageRAdapter).array.size)
        (uiMessageRv.adapter as MessageRAdapter).notifyDataSetChanged()
    }

    companion object {
        fun intent(context: Context): Intent {
            val bundle: Bundle = Bundle()
            return Intent(context, DatabaseActivity::class.java).putExtras(bundle)
        }
    }

    override fun getActivityInfo(): ActivityInfo =
        ActivityInfo(R.layout.activity_database_example, uiToolbar,
            activityListInfo = ActivityListInfo(recyclerView = uiMessageRv))

    override fun onCreate(savedInstanceState: Bundle?) {
        Injector.inject(this)
        super.onCreate(savedInstanceState)

        uiAddBt.setOnClickListener {
            presenter.add(uiAddEt.text.toString())
        }
        uiMessageRv.adapter = MessageRAdapter(presenter.read().toTypedArray())
    }
}