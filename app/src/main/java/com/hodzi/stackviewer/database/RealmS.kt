package com.hodzi.stackviewer.database

import io.realm.Realm

object RealmS {
    val realm: Realm by lazy { Realm.getDefaultInstance() }
}