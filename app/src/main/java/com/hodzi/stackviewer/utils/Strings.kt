package com.hodzi.stackviewer.utils


class Strings {
    companion object {
        const val EMPTY_STRING: String = ""

        fun isEmptyString(string: String): Boolean = string == EMPTY_STRING

        fun parseUrlArgs(url: String): Map<String, String> {
            val result: HashMap<String, String> = HashMap()

            url.split("#")[1]
                .split("&")
                .map { it.split("=") }
                .forEach { result[it[0]] = it[1] }
            return result
        }
    }
}
