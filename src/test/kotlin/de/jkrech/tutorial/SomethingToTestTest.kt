package de.jkrech.tutorial

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

internal class SomethingToTestTest {

    private var testee = SomethingToTest()

    @Tags (
        Tag("success"),
        Tag("failure")
    )
    @Test
    fun `should success`() {
        // when
        val result = testee.testing()

        // then
        assertEquals(true, result)
    }

    @Tag("failure")
    @Test
    fun `should fail`() {
        // when
        val result = testee.testing()

        // then
        assertEquals(false, result)
    }
}