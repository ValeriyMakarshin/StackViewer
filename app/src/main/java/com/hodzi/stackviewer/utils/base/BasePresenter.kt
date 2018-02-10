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
    var view: V? = null
    protected var bundle: Bundle? = null

    var disposableList: Disposable? = null
    var disposableData: Disposable? = null

    @CallSuper
    open fun attach(view: V, bundle: Bundle? = null) {
        this.view = view
        if (bundle != null) {
            parseArguments(bundle)
        }
        loadData()
    }

    open fun loadData() {

    }

    fun <T : Data> baseObservableListDefaultError(observable: Observable<Block<T>>,
                                                  function: (Block<T>) -> Unit = {}) {
        if (disposableList != null) return
        disposableList = observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                view?.showRefresh()
            }
            .doOnTerminate {
                unsubscribeSubscription()
                view?.hideRefresh()
            }
            .doOnError {
                view?.showRefreshButton()
                view?.showError(it)
            }
            .subscribe { block ->
                block?.items?.run { function(block) }
            }
    }

    fun <T : Data> baseObservableData(observable: Observable<T>,
                                      functionSuccess: (T) -> Unit = {},
                                      functionError: (Throwable) -> Unit = {
                                          view?.showError(it)
                                      }) {
        if (disposableData != null) return
        disposableData = observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                view?.showProgress()
            }
            .doOnTerminate {
                unsubscribeSubscription()
                view?.hideProgress()
            }
            .doOnError {
                functionError(it)
            }
            .subscribe {
                it?.let { functionSuccess(it) }
            }
    }

    @CallSuper
    open fun parseArguments(extras: Bundle) {
        this.bundle = extras
    }

    fun detach() {
        unsubscribeSubscription()
    }

    private fun unsubscribeSubscription() {
        if (disposableList?.isDisposed == false) {
            disposableList?.dispose()
            disposableList = null
        }
        if (disposableData?.isDisposed == false) {
            disposableData?.dispose()
            disposableData = null
        }
    }
}
