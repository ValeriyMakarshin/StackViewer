package com.hodzi.stackviewer.core

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.StringRes
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.hodzi.stackviewer.model.Data
import com.hodzi.stackviewer.utils.KeyboardUtil
import com.hodzi.stackviewer.utils.ui.ActivityInfo
import com.hodzi.stackviewer.utils.ui.ActivityListInfo
import javax.inject.Inject

abstract class BaseActivity<in V : BaseContract.View, P : BaseContract.Presenter<V>> :
    AppCompatActivity(), BaseContract.View, SwipeRefreshLayout.OnRefreshListener {

    @Inject lateinit var presenter: P
    protected var activityListInfo: ActivityListInfo? = null

    protected abstract fun getActivityInfo(): ActivityInfo

    @CallSuper
    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getActivityInfo().layoutId)

        activityListInfo = getActivityInfo().activityListInfo

        activityListInfo?.recyclerView?.layoutManager = getLayoutManager()

        if (getActivityInfo().toolbar != null) {
            setSupportActionBar(getActivityInfo().toolbar)
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        presenter.attach(this as V, intent.extras)
    }

    override fun onResume() {
        super.onResume()
        activityListInfo?.swipeLayout?.setOnRefreshListener(this)
    }

    override fun onPause() {
        activityListInfo?.swipeLayout?.setOnRefreshListener(null)
        super.onPause()
    }

    override fun onStop() {
        presenter.detach()
        super.onStop()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onRefresh() {
        presenter.loadData()
    }

    override fun showRefresh() {
        activityListInfo?.refreshBtn?.visibility = View.GONE
        activityListInfo?.swipeLayout?.visibility = View.VISIBLE
        activityListInfo?.swipeLayout?.post({ activityListInfo?.swipeLayout?.isRefreshing = true })
    }

    override fun hideRefresh() {
        activityListInfo?.swipeLayout?.post({ activityListInfo?.swipeLayout?.isRefreshing = false })
    }

    override fun showRefreshButton() {
        activityListInfo?.refreshBtn?.visibility = View.VISIBLE
    }

    protected open fun getLayoutManager(): RecyclerView.LayoutManager? =
        LinearLayoutManager(this)

    override fun setTitle(title: String) {
        getActivityInfo().toolbar?.title
    }

    override fun showError(@StringRes id: Int) {
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show()
    }

    override fun showProgress() {
        activityListInfo?.processBar?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        activityListInfo?.processBar?.visibility = View.GONE
    }

    override fun hideKeyboard() {
        KeyboardUtil.hide(this)
    }

    override fun showError(throwable: Throwable) {

    }

    override fun <D : Data> showArray(array: Array<D>) {
        activityListInfo?.recyclerView?.apply {
            if (adapter != null && adapter is BaseRAdapter<*, *>) {
                (adapter as BaseRAdapter<*, *>).updateList(array)
            } else {
                adapter = getAdapter(array)
            }
        }
    }

    open fun getAdapter(array: Array<*>): BaseRAdapter<*, out BaseHolder<*>>? {
        return null
    }

}
