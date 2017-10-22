package com.hodzi.stackviewer.database

import com.hodzi.stackviewer.database.entities.Message
import io.realm.Realm


class DatabaseWorkerImpl : DatabaseWorker {
    val realm: Realm = RealmS.realm

    override fun addMessage(message: Message) {
        realm.beginTransaction()
        realm.copyToRealm(message)
        realm.commitTransaction()
    }

    override fun readMessages(): List<Message> = realm.where(Message::class.java).findAll()
}