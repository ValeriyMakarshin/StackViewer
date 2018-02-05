package com.hodzi.stackviewer.utils

import com.hodzi.stackviewer.utils.Strings.Companion.isEmptyString
import com.hodzi.stackviewer.utils.Strings.Companion.parseUrlArgs
import org.junit.Assert.assertEquals
import org.junit.Test

internal class StringsTest {
    @Test
    fun isEmptyStringTest() {
        assertEquals(true, isEmptyString(""))
        assertEquals(true, isEmptyString(Strings.EMPTY_STRING))
        assertEquals(false, isEmptyString("test"))
    }

    @Test
    fun parseUrlArgsTest() {
        val map: Map<String, String> = parseUrlArgs("https://www.google.ru/search#" +
            "newwindow=1&" +
            "safe=off&" +
            "q=test&" +
            "oq=test")
        assertEquals(4, map.size)
        assertEquals("1", map["newwindow"])
        assertEquals("off", map["safe"])
        assertEquals("test", map["q"])
        assertEquals("test", map["oq"])
    }
}
