package com.hodzi.stackviewer

import android.content.Context
import com.hodzi.stackviewer.di.NetModule
import io.appflate.restmock.RESTMockServer

class AndroidTestNetModule(context: Context) : NetModule(context, RESTMockServer.getUrl())
