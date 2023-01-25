package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.basic.BasicTagAttributes
import org.junit.jupiter.api.Test


class BasicTagAttributesTest {
    val attributes = BasicTagAttributes()

    @Test
    fun `basic add works`() {
        attributes["something"] = "other"
        assertThat(attributes.toString()).isEqualTo(" something=\"other\"")
    }

    @Test
    fun `multiple adds works`() {
        attributes["first"] = "firstValue"
        attributes["second"] = "secondValue"
        assertThat(attributes.toString()).isEqualTo(" first=\"firstValue\" second=\"secondValue\"")
    }

    @Test
    fun `add order is significant`() {
        attributes["second"] = "secondValue"
        attributes["first"] = "firstValue"
        assertThat(attributes.toString()).isEqualTo(" second=\"secondValue\" first=\"firstValue\"")
    }

    @Test
    fun `add duplicates replaced`() {
        attributes["second"] = "secondValue"
        attributes["second"] = "changed my mind"
        assertThat(attributes.toString()).isEqualTo(" second=\"changed my mind\"")
    }

    @Test
    fun `putAll works`() {
        val all = mapOf("one" to "1", "two" to "2")
        attributes.putAll(all)
        assertThat(attributes.toString()).isEqualTo(" one=\"1\" two=\"2\"")
    }

    @Test
    fun `remove works`() {
        attributes["something"] = "other"
        attributes.remove("something")
        assertThat(attributes.toString()).isEqualTo("")
    }

    @Test
    fun `classes becomes class on toString`() {
        attributes["classes"] = "other"
        assertThat(attributes.toString()).isEqualTo(" class=\"other\"")
    }

}