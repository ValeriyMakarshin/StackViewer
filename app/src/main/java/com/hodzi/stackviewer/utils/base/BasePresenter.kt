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

    private var disposableList: Disposable? = null
    private var disposableData: Disposable? = null

    @CallSuper
    open fun attach(v: V, bundle: Bundle? = null) {
        this.view = v
        this.bundle = bundle
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
            .doOnSubscribe({
                view?.showRefresh()
            })
            .doOnTerminate({
                unsubscribeSubscription()
            })
            .doOnError { throwable ->
                view?.hideRefresh()
                view?.showRefreshButton()
            }
//            .onErrorReturn({
//            })
            .subscribe({ block ->
                view?.hideRefresh()
                if (block?.items != null) {
                    view?.hideProgress()
                    function(block)
                }
            })
    }

    fun <T : Data> baseObservableData(observable: Observable<T>,
                                      functionSuccess: (T) -> Unit = {},
                                      functionError: (Throwable) -> Unit = {}) {
        if (disposableData != null) return
        disposableData = observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe({
                view?.showProgress()
            })
            .doOnTerminate({
                unsubscribeSubscription()
                view?.hideProgress()
            })
            .onErrorReturn({ throwable ->
                view?.hideProgress()
                functionError(throwable)
                disposableData = null
                null
            })
            .subscribe({ data ->
                if (data != null) {
                    view?.hideProgress()
                    functionSuccess(data)
                }
                disposableData = null
            })
    }


    protected open fun parseArguments(extras: Bundle) {
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