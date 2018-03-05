package com.hodzi.stackviewer.core

import android.os.Bundle
import android.support.annotation.CallSuper
import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.model.Data
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


abstract class BasePresenter<V : BaseContract.View> : BaseContract.Presenter<V> {
    var view: V? = null
    protected var bundle: Bundle? = null

    var disposableList: Disposable? = null
    var disposableData: Disposable? = null

    @CallSuper override fun attach(view: V, bundle: Bundle?) {
        this.view = view
        if (bundle != null) {
            parseArguments(bundle)
        }
        loadData()
    }

    @CallSuper open fun parseArguments(extras: Bundle) {
        this.bundle = extras
    }

    override fun loadData() {

    }

    inline fun <reified T : Data>
        baseObservableListDefaultError(observable: Observable<Block<T>>,
                                       crossinline function: (Block<T>) -> Unit = {
                                           view?.showArray(
                                               it.items.toTypedArray())
                                       }) {
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
            .subscribe(
                { block ->
                    block?.items?.run { function(block) }
                },
                {
                    view?.showRefreshButton()
                    view?.showError(it)
                })
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
            .subscribe(
                {
                    it?.let { functionSuccess(it) }
                },
                {
                    functionError(it)
                })
    }

    override fun detach() {
        unsubscribeSubscription()
    }

    open fun unsubscribeSubscription() {
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
