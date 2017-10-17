package com.hodzi.stackviewer.utils.base

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.hodzi.stackviewer.utils.KeyboardUtil
import com.hodzi.stackviewer.utils.ui.ActivityInfo
import com.hodzi.stackviewer.utils.ui.ActivityListInfo
import javax.inject.Inject

abstract class BaseActivity<V : BaseView, P : BasePresenter<V>> : AppCompatActivity(), BaseView {
    @Inject protected lateinit var presenter: P
    protected var activityListInfo: ActivityListInfo? = null

    protected abstract fun getActivityInfo(): ActivityInfo

    @CallSuper
    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getActivityInfo().layoutId)

        activityListInfo = getActivityInfo().activityListInfo

        activityListInfo?.recyclerView?.layoutManager = getLayoutManager()

        setSupportActionBar(getActivityInfo().toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        presenter.attach(this as V, intent.extras)
    }

    override fun onStop() {
        presenter.detach()
        super.onStop()
    }

    protected open fun getLayoutManager(): RecyclerView.LayoutManager? =
        LinearLayoutManager(this)

    override fun <T> showList(list: List<T>) {
    }

    override fun setTitle(title: String) {
        getActivityInfo().toolbar?.title
    }

    override fun showProgress() {
        activityListInfo?.processbar?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        activityListInfo?.processbar?.visibility = View.GONE
    }

    override fun hideKeyboard() {
        KeyboardUtil.hide(this)
    }
}
