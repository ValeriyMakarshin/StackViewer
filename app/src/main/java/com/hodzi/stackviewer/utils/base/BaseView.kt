package com.hodzi.stackviewer.utils.base

interface BaseView {
    fun setTitle(title: String)

    fun showProgress()

    fun hideProgress()

    fun hideKeyboard()
}