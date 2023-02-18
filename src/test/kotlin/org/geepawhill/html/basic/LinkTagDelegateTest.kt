package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.model.Element.Companion.flat
import org.junit.jupiter.api.Test

class LinkTagDelegateTest {
    val styles = StylesDelegate()

    @Test
    fun `constructor sets fields if present`() {
        val link = LinkTagDelegate(styles, "class", "href", "target")
        val expected = """<a class="class" href="href" target="target"></a>"""
        assertThat(link.flat).isEqualTo(expected)
    }

    @Test
    fun `field overrides in details`() {
        val link = LinkTagDelegate(styles) {
            classes += "class"
            href = "href"
            target = "target"
        }
        val expected = """<a class="class" href="href" target="target"></a>"""
        assertThat(link.flat).isEqualTo(expected)
    }

    @Test
    fun `DSL function same arguments as constructor`() {
        val container = InternalTagDelegate(styles, "div").apply {
            a("class", "href", "target")
        }
        val expected = """<div><a class="class" href="href" target="target"></a></div>"""
        assertThat(container.flat).isEqualTo(expected)
    }

    @Test
    fun `Adding text using plus works`() {
        val link = LinkTagDelegate(styles).apply {
            +"This is text."
        }
        val expected = """<a>This is text.</a>"""
        assertThat(link.flat).isEqualTo(expected)
    }

    @Test
    fun `Adding tag using plus works`() {
        val link = LinkTagDelegate(styles).apply {
            +InternalTagDelegate(styles, "div")
        }
        val expected = """<a><div></div></a>"""
        assertThat(link.flat).isEqualTo(expected)
    }
}
