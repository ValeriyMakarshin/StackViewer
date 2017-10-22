package com.hodzi.stackviewer.database

import android.os.Bundle
import com.hodzi.stackviewer.database.entities.Message
import com.hodzi.stackviewer.utils.base.BasePresenter

class DatabasePresenter(val databaseWorker: DatabaseWorker) : BasePresenter<DatabaseView>() {
    override fun attach(v: DatabaseView, bundle: Bundle?) {
        super.attach(v, bundle)
    }

    fun add(text: String) {
        val message = Message(text, System.currentTimeMillis())
        databaseWorker.addMessage(message)
        view?.update(message)
    }

    fun read(): List<Message> = databaseWorker.readMessages()
}