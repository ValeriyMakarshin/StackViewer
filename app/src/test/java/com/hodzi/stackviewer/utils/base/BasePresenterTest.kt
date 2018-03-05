package com.hodzi.stackviewer.utils.base

import android.os.Bundle
import com.hodzi.stackviewer.RxHook
import com.hodzi.stackviewer.core.BasePresenter
import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.model.Data
import com.hodzi.stackviewer.utils.Generator
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verifyNoMoreInteractions
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class BasePresenterTest {
    @Rule @JvmField
    val schedulers = RxHook()

    @Spy private lateinit var spyBasePresenter: BasePresenter<BaseView>
    @Mock private lateinit var mockBaseView: BaseView

    @Test fun attachTest() {
        spyBasePresenter.attach(mockBaseView)

        Assert.assertNotNull(mockBaseView)
        verify(spyBasePresenter).loadData()
    }

    @Test fun attachTestWithBundle() {
        val expectedBundle: Bundle = mock()

        spyBasePresenter.attach(mockBaseView, expectedBundle)

        Assert.assertNotNull(mockBaseView)
        verify(spyBasePresenter).parseArguments(expectedBundle)
        verify(spyBasePresenter).loadData()
    }

    @Test fun baseObservableListDefaultErrorTest() {
        spyBasePresenter.attach(mockBaseView)
        val expectedBlock = Generator.create(Block::class.java)
        val mockFunctionSuccess: (Block<*>) -> Unit = mock()

        spyBasePresenter.baseObservableListDefaultError(Observable.just(expectedBlock), mockFunctionSuccess)

        verify(mockBaseView).showRefresh()
        verify(mockBaseView).hideRefresh()
        verify(mockFunctionSuccess).invoke(expectedBlock)
        Assert.assertNotNull(spyBasePresenter.disposableList)
    }

    @Test fun baseObservableListDefaultErrorTestError() {
        spyBasePresenter.attach(mockBaseView)
        val expectedThrowable = Throwable()
        val functionSuccess: (Block<*>) -> Unit = mock()

        spyBasePresenter.baseObservableListDefaultError(Observable.error(expectedThrowable),
            functionSuccess)

        verify(mockBaseView).showRefresh()
        verify(mockBaseView).hideRefresh()
        verify(mockBaseView).showRefreshButton()
        verify(mockBaseView).showError(expectedThrowable)
        verifyNoMoreInteractions(functionSuccess)
        Assert.assertNotNull(spyBasePresenter.disposableList)
    }

    @Test fun baseObservableDataTest() {
        spyBasePresenter.attach(mockBaseView)
        val expectedData = Data()
        val mockFunctionSuccess: (Any) -> Unit = mock()
        val mockFunctionError: (Throwable) -> Unit = mock()

        spyBasePresenter.baseObservableData(Observable.just(expectedData),
            mockFunctionSuccess, mockFunctionError)

        verify(mockBaseView).showProgress()
        verify(mockBaseView).hideProgress()
        verify(mockFunctionSuccess).invoke(expectedData)
        verifyNoMoreInteractions(mockFunctionError)
        Assert.assertNotNull(spyBasePresenter.disposableData)
    }

    @Test fun baseObservableDataTestError() {
        spyBasePresenter.attach(mockBaseView)
        val expectedThrowable = Throwable()
        val mockFunctionSuccess: (Any) -> Unit = mock()
        val mockFunctionError: (Throwable) -> Unit = mock()

        spyBasePresenter.baseObservableData(Observable.error(expectedThrowable),
            mockFunctionSuccess, mockFunctionError)

        verify(mockBaseView).showProgress()
        verify(mockBaseView).hideProgress()
        verifyNoMoreInteractions(mockFunctionSuccess)
        verify(mockFunctionError).invoke(expectedThrowable)
        Assert.assertNotNull(spyBasePresenter.disposableData)
    }

    @Test fun detachTest() {
        spyBasePresenter.detach()

        verify(spyBasePresenter).unsubscribeSubscription()
    }

    @Test fun unsubscribeSubscriptionTestData() {
        val mockDisposable: Disposable = mock()

        spyBasePresenter.disposableData = mockDisposable

        spyBasePresenter.unsubscribeSubscription()

        verify(mockDisposable).isDisposed
        verify(mockDisposable).dispose()
        Assert.assertNull(spyBasePresenter.disposableData)
    }

    @Test fun unsubscribeSubscriptionTestDataDisposed() {
        val mockDisposable: Disposable = mock {
            on { this.isDisposed }.doReturn(true)
        }
        spyBasePresenter.disposableData = mockDisposable

        spyBasePresenter.unsubscribeSubscription()

        verify(mockDisposable).isDisposed
        verifyNoMoreInteractions(mockDisposable)
        Assert.assertEquals(spyBasePresenter.disposableData, mockDisposable)
    }

    @Test fun unsubscribeSubscriptionTestList() {
        val mockDisposable: Disposable = mock()
        spyBasePresenter.disposableList = mockDisposable

        spyBasePresenter.unsubscribeSubscription()

        verify(mockDisposable).isDisposed
        verify(mockDisposable).dispose()
        Assert.assertNull(spyBasePresenter.disposableList)
    }

    @Test fun unsubscribeSubscriptionTestListDisposed() {
        val mockDisposable: Disposable = mock {
            on { this.isDisposed }.doReturn(true)
        }
        spyBasePresenter.disposableList = mockDisposable

        spyBasePresenter.unsubscribeSubscription()

        verify(mockDisposable).isDisposed
        verifyNoMoreInteractions(mockDisposable)
        Assert.assertEquals(spyBasePresenter.disposableList, mockDisposable)
    }
}
