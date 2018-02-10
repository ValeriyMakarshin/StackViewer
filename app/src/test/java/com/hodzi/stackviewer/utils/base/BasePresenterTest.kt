package com.hodzi.stackviewer.utils.base

import android.os.Bundle
import com.hodzi.stackviewer.RxHook
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
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
}
