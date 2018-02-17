package com.hodzi.stackviewer.utils.base

import com.hodzi.stackviewer.model.Data

interface BaseView {
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
