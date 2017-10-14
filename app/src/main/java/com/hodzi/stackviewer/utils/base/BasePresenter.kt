package com.hodzi.stackviewer.utils.base

import android.os.Bundle
import android.support.annotation.CallSuper
import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.model.Data
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class BasePresenter<V : BaseView> {
    protected var view: V? = null
    protected var bundle: Bundle? = null

    private var disposable: Disposable? = null

    @CallSuper
    open fun attach(v: V, bundle: Bundle? = null) {
        this.view = v
        this.bundle = bundle
        loadData()
    }

    protected open fun loadData() {

    }

    fun <T : Data> baseObservableListDefaultError(observable: Observable<Block<T>>,
                                                  function: (Block<T>) -> Unit) {
        if (disposable != null) return
        disposable = observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe({
                if (view != null) {
                }
            })
            .doOnTerminate({
                unsubscribeSubscription()
                if (view != null) {
                }
            })
            .onErrorReturn({ throwable ->
                if (view != null) {
                }
                null
            })
            .subscribe({ block ->
                function(block)
            })

    }


    fun detach() {
        unsubscribeSubscription()
    }

    private fun unsubscribeSubscription() {
        if (disposable?.isDisposed == false) {
            disposable?.dispose()
            disposable = null
        }
    }
}