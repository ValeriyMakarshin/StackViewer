package com.hodzi.stackviewer.utils.base

import android.os.Bundle
import android.support.annotation.CallSuper

abstract class BasePresenter<V : BaseView> {
    protected var view: V? = null
    protected var bundle: Bundle? = null

    fun p1(){

    }

    @CallSuper
    open fun attach(v: V, bundle: Bundle? = null) {
        this.view = v
        this.bundle = bundle
    }
}