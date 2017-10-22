package com.hodzi.stackviewer.database

import android.os.Bundle
import com.hodzi.stackviewer.utils.base.BasePresenter

class DatabasePresenter(databaseWorker: DatabaseWorker) : BasePresenter<DatabaseView>() {
    override fun attach(v: DatabaseView, bundle: Bundle?) {
        super.attach(v, bundle)
    }
}