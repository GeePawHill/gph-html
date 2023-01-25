package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.basic.BasicInternalTag
import org.geepawhill.html.basic.BasicLink
import org.junit.jupiter.api.Test

class LinkMakerTest {
    @Test
    fun `constructor sets fields if present`() {
        val link = BasicLink("class", "href", "target")
        val expected = """<a class="class" href="href" target="target"></a>"""
        assertThat(link.emit()).isEqualTo(expected)
    }

    @Test
    fun `field overrides in details`() {
        val link = BasicLink() {
            classes = "class"
            href = "href"
            target = "target"
        }
        val expected = """<a class="class" href="href" target="target"></a>"""
        assertThat(link.emit()).isEqualTo(expected)
    }

    @Test
    fun `DSL function same arguments as constructor`() {
        val container = BasicInternalTag("div").apply {
            a("class", "href", "target")
        }
        val expected = """<div><a class="class" href="href" target="target"></a></div>"""
        assertThat(container.emit()).isEqualTo(expected)
    }

    @Test
    fun `Adding text using plus works`() {
        val link = BasicLink().apply {
            +"This is text."
        }
        val expected = """<a>This is text.</a>"""
        assertThat(link.emit()).isEqualTo(expected)
    }

    @Test
    fun `Adding tag using plus works`() {
        val link = BasicLink().apply {
            +BasicInternalTag("div")
        }
        val expected = """<a><div></div></a>"""
        assertThat(link.emit()).isEqualTo(expected)
    }

}