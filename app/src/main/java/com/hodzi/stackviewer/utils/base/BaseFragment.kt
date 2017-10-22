package com.hodzi.stackviewer.utils.base

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hodzi.stackviewer.utils.KeyboardUtil
import com.hodzi.stackviewer.utils.ui.ActivityInfo
import com.hodzi.stackviewer.utils.ui.ActivityListInfo
import javax.inject.Inject

abstract class BaseFragment<V : BaseView, P : BasePresenter<V>> : Fragment(), BaseView {
    @Inject protected lateinit var presenter: P
    protected var activityListInfo: ActivityListInfo? = null

    protected abstract fun getActivityInfo(): ActivityInfo

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
        inflater?.inflate(getActivityInfo().layoutId, container, false)

    @CallSuper
    @Suppress("UNCHECKED_CAST")
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityListInfo = getActivityInfo().activityListInfo

        activityListInfo?.recyclerView?.layoutManager = getLayoutManager()

        presenter.attach(this as V, arguments)

        if (getActivityInfo().toolbar != null) {
            setHasOptionsMenu(true)
        }
    }

    override fun onStop() {
        presenter.detach()
        super.onStop()
    }

    protected open fun getLayoutManager(): RecyclerView.LayoutManager? =
        LinearLayoutManager(context)

    override fun setTitle(title: String) {
        getActivityInfo().toolbar?.title
    }

    override fun showError(@StringRes id: Int) {
        Toast.makeText(context, id, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        activityListInfo?.processbar?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        activityListInfo?.processbar?.visibility = View.GONE
    }

    override fun hideKeyboard() {
        KeyboardUtil.hide(activity)
    }

    override fun finish() {
        activity.onBackPressed()
    }
}