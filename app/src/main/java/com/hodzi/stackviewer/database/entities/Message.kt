package com.hodzi.stackviewer.database.entities

import io.realm.RealmObject

open class Message() : RealmObject() {
    constructor(text: String, time: Long) : this() {
        this.text = text
        this.time = time
    }

    var text: String? = null
    var time: Long? = null
}