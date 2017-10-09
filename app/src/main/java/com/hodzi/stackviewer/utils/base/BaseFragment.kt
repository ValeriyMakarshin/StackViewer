package com.hodzi.stackviewer.utils.base

import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hodzi.stackviewer.utils.ui.ActivityInfo
import javax.inject.Inject





abstract class BaseFragment<V : BaseView, P : BasePresenter<V>> : Fragment(), BaseView {
    @Inject protected lateinit var presenter: P

    protected abstract fun getActivityInfo(): ActivityInfo


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
        inflater?.inflate(getActivityInfo().layoutId, container, false)

    @CallSuper
    @Suppress("UNCHECKED_CAST")
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attach(this as V, arguments)

        if (getActivityInfo().toolbar != null) {
            setHasOptionsMenu(true)
        }
    }

    override fun onStop() {
        presenter.detach();
        super.onStop()
    }
}