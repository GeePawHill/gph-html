package org.geepawhill.html.formatter

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.map.KeyAndValue
import org.junit.jupiter.api.Test

class PrettyFormattterTest {
    val formatter = PrettyFormatter()

    @Test
    fun `handles empty tag`() {
        formatter.emptyTag("tag", listOf(KeyAndValue("a", "avalue"), KeyAndValue("b", "bvalue")))
        assertThat(formatter.toString().trim()).isEqualTo("<tag a=\"avalue\" b=\"bvalue\">")
    }

    @Test
    fun `handles text`() {
        formatter.text("something")
        assertThat(formatter.toString()).isEqualTo("something")
    }

    @Test
    fun `handles open container tag`() {
        formatter.openContainerTag("tag", listOf(KeyAndValue("key", "value")))
        assertThat(formatter.toString().trim()).isEqualTo("<tag key=\"value\">")
    }

    @Test
    fun `handles close container tag`() {
        formatter.closeContainerTag("tag")
        assertThat(formatter.toString()).isEqualTo("\n</tag>")
    }

    @Test
    fun `handles child tags`() {
        formatter.openContainerTag("parent", emptyList())
        formatter.emptyTag("child", emptyList())
        formatter.closeContainerTag("parent")
        val expected = "\n<parent>\n  <child>\n</parent>"
        assertThat(formatter.toString()).isEqualTo(expected)
    }

    @Test
    fun `handles open selector`() {
        formatter.openSelector("rule")
        assertThat(formatter.toString()).isEqualTo("\nrule {")
    }

    @Test
    fun `handles close selector`() {
        formatter.closeSelector()
        assertThat(formatter.toString()).isEqualTo("\n}")
    }

    @Test
    fun `handles declaration`() {
        formatter.declaration(KeyAndValue("width", "100px"))
        assertThat(formatter.toString()).isEqualTo("\nwidth: 100px;")
    }

    @Test
    fun `handles start styles`() {
        formatter.startStyles()
        assertThat(formatter.toString()).isEqualTo("\n<style>")
    }

    @Test
    fun `handles end styles`() {
        formatter.endStyles()
        assertThat(formatter.toString()).isEqualTo("\n</style>")
    }

    @Test
    fun `handles start rule`() {
        formatter.startRule("*")
        assertThat(formatter.toString()).isEqualTo("\n* {")
    }

    @Test
    fun `handles end rule`() {
        formatter.endRule()
        assertThat(formatter.toString()).isEqualTo("\n}")
    }

    @Test
    fun `handles start media`() {
        formatter.startQuery("printer only")
        assertThat(formatter.toString()).isEqualTo("\n@media printer only {")
    }

    @Test
    fun `handles end media`() {
        formatter.endQuery()
        assertThat(formatter.toString()).isEqualTo("\n}")
    }
}
