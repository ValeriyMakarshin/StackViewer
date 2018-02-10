package com.hodzi.stackviewer.utils.base

import android.os.Bundle
import com.hodzi.stackviewer.RxHook
import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.utils.Generator
import io.reactivex.Observable
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito
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

        Assert.assertNotEquals(baseView, null)
        verify(basePresenter).loadData()
    }

    @Test fun attachTestWithBundle() {
        val bundle: Bundle = Mockito.mock(Bundle::class.java)

        basePresenter.attach(baseView, bundle)

        Assert.assertNotEquals(baseView, null)
        verify(basePresenter).parseArguments(bundle)
        verify(basePresenter).loadData()
    }

    @Test fun baseObservableListDefaultErrorTest() {
        basePresenter.attach(baseView)
        val block = Generator.create(Block::class.java)
        val functionSuccess: Action1 = Mockito.mock(Action1::class.java)

        basePresenter.baseObservableListDefaultError(Observable.just(block), functionSuccess::call)

        verify(baseView).showRefresh()
        verify(baseView).hideRefresh()
        verify(functionSuccess).call(block)
        Assert.assertNotEquals(basePresenter.disposableList, null)
    }

    @Test fun baseObservableListDefaultErrorTestError() {
        basePresenter.attach(baseView)
        val throwable = Throwable()
        val functionSuccess: Action1 = Mockito.mock(Action1::class.java)
        Mockito
            .doNothing()
            .`when`(functionSuccess).call(any())

        basePresenter.baseObservableListDefaultError(Observable.error(throwable),
            functionSuccess::call)

        verify(baseView).showRefresh()
        verify(baseView).hideRefresh()
        verify(baseView).showRefreshButton()
        verify(baseView).showError(throwable)
        verify(functionSuccess, never()).call(anyMock())
    }

    interface Action1 {
        fun call(block: Block<*>)
    }


    private fun <T> anyMock(): T {
        val T = Mockito.any<T>()
        return uninitialized()
    }

    private fun <T> uninitialized(): T = null as T
}
