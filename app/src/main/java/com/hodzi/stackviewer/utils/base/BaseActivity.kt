package com.hodzi.stackviewer.utils.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hodzi.stackviewer.utils.ui.ActivityInfo
import javax.inject.Inject

abstract class BaseActivity<V : BaseView, P : BasePresenter<V>> : AppCompatActivity(), BaseView {

    @Inject public var presenter: P? = null

    protected abstract fun getActivityInfo(): ActivityInfo

    @Suppress("UNCHECKED_CAST")
    final override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getActivityInfo().layoutId)

        setSupportActionBar(getActivityInfo().toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        presenter?.attach(this as V, intent.extras)
        presenter?.p1()
    }

    protected abstract fun parseArguments(extras: Bundle)
}
