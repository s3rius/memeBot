package com.company.s3rius.memebot

import org.junit.Assert.assertEquals
import org.junit.Ignore
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ExampleUnitTest {
    @Test
    @Throws(Exception::class)
    fun addition_isCorrect() {
        assertEquals(4, (2 + 2).toLong())
    }

    @Test
    fun lambdas_test() {
        var list = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8)
        list = list.filter { it in 4..6 }
        assertEquals(listOf(4,5,6), list)
    }
}