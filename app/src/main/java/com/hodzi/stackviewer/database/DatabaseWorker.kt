package com.hodzi.stackviewer.database

import com.hodzi.stackviewer.database.entities.Message

interface DatabaseWorker {
    fun addMessage(message: Message)

    fun readMessages(): List<Message>
}