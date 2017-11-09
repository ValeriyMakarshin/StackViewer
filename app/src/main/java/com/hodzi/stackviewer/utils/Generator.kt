package com.hodzi.stackviewer.utils

import java.lang.reflect.Constructor

/***
 * Only for testing
 *
 */

class Generator {
    companion object {
        fun <T> create(clazz: Class<T>): T {
            val eny: Any = when (clazz) {
                Int::class.java -> {
                    0
                }
                String::class.java -> {
                    ""
                }
                Boolean::class.java -> {
                    false
                }
                Char::class.java -> {
                    '_'
                }
                List::class.java,
                ArrayList::class.java -> {
                    ArrayList<Any>()
                }
                else -> {
                    val constructor: Constructor<*> = clazz.constructors[0]
                    constructor.newInstance(*constructor.parameterTypes.map { create(it) }.toTypedArray())
                }
            }
            return eny as T
        }
    }
}