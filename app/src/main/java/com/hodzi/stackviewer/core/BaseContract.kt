package com.hodzi.stackviewer.core

import android.os.Bundle
import com.hodzi.stackviewer.model.Data

interface BaseContract {
    interface Navigator

    interface View {
        fun setTitle(title: String)

        fun showError(id: Int)

        fun showProgress()

        fun hideProgress()

        fun hideKeyboard()

        fun finish()

        fun <D : Data> showArray(array: Array<D>)

        fun showRefresh()

        fun hideRefresh()

        fun showRefreshButton()

        fun showError(throwable: Throwable)
    }

    interface Presenter<in V : BaseContract.View> {
        fun loadData()

        fun attach(view: V, bundle: Bundle? = null)

        fun detach()
    }
}
