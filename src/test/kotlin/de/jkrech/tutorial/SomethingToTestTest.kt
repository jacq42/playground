package de.jkrech.tutorial

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SomethingToTestTest {

    private var testee = SomethingToTest()

    @Test
    fun `should success`() {
        // when
        val result = testee.testing()

        // then
        assertEquals(true, result)
    }

    @Test
    fun `should fail`() {
        // when
        val result = testee.testing()

        // then
        assertEquals(false, result)
    }
}