package com.hodzi.stackviewer.database

import io.realm.Realm

class DatabaseWorkerImpl : DatabaseWorker {
    val realm: Realm = RealmS.realm

}