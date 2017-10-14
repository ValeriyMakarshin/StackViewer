package com.hodzi.stackviewer.utils.base

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import com.hodzi.stackviewer.utils.ui.ActivityInfo
import javax.inject.Inject

abstract class BaseActivity<V : BaseView, P : BasePresenter<V>> : AppCompatActivity(), BaseView {

    @Inject protected lateinit var presenter: P

    protected abstract fun getActivityInfo(): ActivityInfo

    @CallSuper
    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getActivityInfo().layoutId)

        setSupportActionBar(getActivityInfo().toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        presenter.attach(this as V, intent.extras)
    }

    override fun onStop() {
        presenter.detach();
        super.onStop()
    }

    protected abstract fun parseArguments(extras: Bundle)
}
