package com.hodzi.stackviewer.utils.base

import android.os.Bundle
import com.hodzi.stackviewer.RxHook
import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.model.Data
import com.hodzi.stackviewer.utils.Generator
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.never
import org.mockito.Mockito.verify
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BasePresenterTest {
    @Rule @JvmField
    val schedulers = RxHook()

    @Spy private lateinit var basePresenter: BasePresenter<BaseView>
    @Mock private lateinit var baseView: BaseView

    @Before fun setUp() {
    }

    @Test fun attachTest() {
        basePresenter.attach(baseView)

        Assert.assertNotNull(baseView)
        verify(basePresenter).loadData()
    }

    @Test fun attachTestWithBundle() {
        val bundle: Bundle = mock()

        basePresenter.attach(baseView, bundle)

        Assert.assertNotNull(baseView)
        verify(basePresenter).parseArguments(bundle)
        verify(basePresenter).loadData()
    }

    @Test fun baseObservableListDefaultErrorTest() {
        basePresenter.attach(baseView)
        val block = Generator.create(Block::class.java)
        val functionSuccess: (Block<*>) -> Unit = mock()

        basePresenter.baseObservableListDefaultError(Observable.just(block), functionSuccess)

        verify(baseView).showRefresh()
        verify(baseView).hideRefresh()
        verify(functionSuccess).invoke(block)
        Assert.assertNotNull(basePresenter.disposableList)
    }

    @Test fun baseObservableListDefaultErrorTestError() {
        basePresenter.attach(baseView)
        val throwable = Throwable()
        val functionSuccess: (Block<*>) -> Unit = mock()

        basePresenter.baseObservableListDefaultError(Observable.error(throwable),
            functionSuccess)

        verify(baseView).showRefresh()
        verify(baseView).hideRefresh()
        verify(baseView).showRefreshButton()
        verify(baseView).showError(throwable)
        verify(functionSuccess, never()).invoke(any())
        Assert.assertNotNull(basePresenter.disposableList)
    }

    @Test fun baseObservableDataTest() {
        basePresenter.attach(baseView)
        val data = Data()
        val functionSuccess: (Any) -> Unit = mock()
        val functionError: (Throwable) -> Unit = mock()

        basePresenter.baseObservableData(Observable.just(data),
            functionSuccess, functionError)

        verify(baseView).showProgress()
        verify(baseView).hideProgress()
        verify(functionSuccess).invoke(data)
        verify(functionError, never()).invoke(any())
        Assert.assertNotNull(basePresenter.disposableData)
    }

    @Test fun baseObservableDataTestError() {
        basePresenter.attach(baseView)
        val throwable = Throwable()
        val functionSuccess: (Any) -> Unit = mock()
        val functionError: (Throwable) -> Unit = mock()

        basePresenter.baseObservableData(Observable.error(throwable),
            functionSuccess, functionError)

        verify(baseView).showProgress()
        verify(baseView).hideProgress()
        verify(functionSuccess, never()).invoke(any())
        verify(functionError).invoke(throwable)
        Assert.assertNotNull(basePresenter.disposableData)
    }

    @Test fun detachTest() {
        basePresenter.detach()

        verify(basePresenter).unsubscribeSubscription()
    }

    @Test fun unsubscribeSubscriptionTestData() {
        val disposable: Disposable = mock()

        basePresenter.disposableData = disposable

        basePresenter.unsubscribeSubscription()

        verify(disposable).isDisposed
        verify(disposable).dispose()
        Assert.assertNull(basePresenter.disposableData)
    }

    @Test fun unsubscribeSubscriptionTestDataDisposed() {
        val disposable: Disposable = mock {
            on { this.isDisposed }.doReturn(true)
        }
        basePresenter.disposableData = disposable

        basePresenter.unsubscribeSubscription()

        verify(disposable).isDisposed
        verify(disposable, never()).dispose()
        Assert.assertEquals(basePresenter.disposableData, disposable)
    }

    @Test fun unsubscribeSubscriptionTestList() {
        val disposable: Disposable = mock()
        basePresenter.disposableList = disposable

        basePresenter.unsubscribeSubscription()

        verify(disposable).isDisposed
        verify(disposable).dispose()
        Assert.assertNull(basePresenter.disposableList)
    }

    @Test fun unsubscribeSubscriptionTestListDisposed() {
        val disposable: Disposable = mock {
            on { this.isDisposed }.doReturn(true)
        }
        basePresenter.disposableList = disposable

        basePresenter.unsubscribeSubscription()

        verify(disposable).isDisposed
        verify(disposable, never()).dispose()
        Assert.assertEquals(basePresenter.disposableList, disposable)
    }
}
