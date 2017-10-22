package com.hodzi.stackviewer.database

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.hodzi.stackviewer.R
import com.hodzi.stackviewer.di.Injector
import com.hodzi.stackviewer.utils.base.BaseActivity
import com.hodzi.stackviewer.utils.ui.ActivityInfo

class DatabaseActivity : BaseActivity<DatabaseView, DatabasePresenter>(), DatabaseView {
    companion object {
        fun intent(context: Context): Intent {
            val bundle: Bundle = Bundle()
            return Intent(context, DatabaseActivity::class.java).putExtras(bundle)
        }
    }

    override fun getActivityInfo(): ActivityInfo = ActivityInfo(R.layout.activity_database_example)

    override fun onCreate(savedInstanceState: Bundle?) {
        Injector.inject(this)

        super.onCreate(savedInstanceState)
    }
}