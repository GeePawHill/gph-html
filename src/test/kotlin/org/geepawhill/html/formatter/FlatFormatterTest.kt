package org.geepawhill.html.formatter

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.map.KeyAndValue
import org.junit.jupiter.api.Test

class FlatFormatterTest {
    val formatter = FlatFormatter()

    @Test
    fun `handles empty tag`() {
        formatter.emptyTag("tag", listOf(KeyAndValue("a", "avalue"), KeyAndValue("b", "bvalue")))
        assertThat(formatter.toString()).isEqualTo("<tag a=\"avalue\" b=\"bvalue\">")
    }

    @Test
    fun `handles text`() {
        formatter.text("something")
        assertThat(formatter.toString()).isEqualTo("something")
    }

    @Test
    fun `handles open container tag`() {
        formatter.openContainerTag("tag", listOf(KeyAndValue("key", "value")))
        assertThat(formatter.toString()).isEqualTo("<tag key=\"value\">")
    }

    @Test
    fun `handles close container tag`() {
        formatter.closeContainerTag("tag")
        assertThat(formatter.toString()).isEqualTo("</tag>")
    }

    @Test
    fun `handles open selector`() {
        formatter.openSelector("rule")
        assertThat(formatter.toString()).isEqualTo(" rule {")
    }

    @Test
    fun `handles close selector`() {
        formatter.closeSelector()
        assertThat(formatter.toString()).isEqualTo(" }")
    }

    @Test
    fun `handles declaration`() {
        formatter.declaration(KeyAndValue("width", "100px"))
        assertThat(formatter.toString()).isEqualTo(" width: 100px;")
    }

    @Test
    fun `handles start styles`() {
        formatter.startStyles()
        assertThat(formatter.toString()).isEqualTo("<style>")
    }

    @Test
    fun `handles end styles`() {
        formatter.endStyles()
        assertThat(formatter.toString()).isEqualTo("</style>")
    }
}
