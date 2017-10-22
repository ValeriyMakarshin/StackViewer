package com.hodzi.stackviewer.database.entities

import io.realm.RealmObject

open class Message : RealmObject() {
    var time: String? = null
    var lastName: String? = null
}