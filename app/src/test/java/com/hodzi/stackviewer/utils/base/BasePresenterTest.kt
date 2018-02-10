package com.hodzi.stackviewer.utils.base

import android.os.Bundle
import com.hodzi.stackviewer.RxHook
import com.hodzi.stackviewer.model.Block
import com.hodzi.stackviewer.utils.Generator
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Observable
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
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
        val bundle: Bundle = mock()

        basePresenter.attach(baseView, bundle)

        Assert.assertNotEquals(baseView, null)
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
        Assert.assertNotEquals(basePresenter.disposableList, null)
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
        Assert.assertNotEquals(basePresenter.disposableList, null)
    }

}
