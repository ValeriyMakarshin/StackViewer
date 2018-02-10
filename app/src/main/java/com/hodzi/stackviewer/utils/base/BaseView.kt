package com.hodzi.stackviewer.utils.base

interface BaseView {
    fun setTitle(title: String)

    fun showError(id: Int)

    fun showProgress()

    fun hideProgress()

    fun hideKeyboard()

    fun finish()

    fun showRefresh()

    fun hideRefresh()

    fun showRefreshButton()

    fun showError(throwable: Throwable)
}
