package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.builder.FlatPrinter
import org.junit.jupiter.api.Test

class InternalTagDelegateTest {

    val printer = FlatPrinter()
    val styles = StylesDelegate()

    @Test
    fun `nested tags with construction`() {
        val tag = InternalTagDelegate(styles, "div").apply {
            +InternalTagDelegate(styles, "li")
        }
        assertThat(tag.elements).hasSize(1)
        assertThat(printer.print(tag)).isEqualTo("<div><li></li></div>")
    }

    @Test
    fun `nested tags with dsl`() {
        val tag = InternalTagDelegate(styles, "div").apply {
            ul {
                li { }
                +"Hello"
            }
        }
        assertThat(printer.print(tag)).isEqualTo("<div><ul><li></li>Hello</ul></div>")
    }

    @Test
    fun `nested texts construction`() {
        val tag = InternalTagDelegate(styles, "div").apply {
            +"hello"
        }
        assertThat(printer.print(tag)).isEqualTo("<div>hello</div>")
    }

    @Test
    fun `nested texts with encoding`() {
        val tag = InternalTagDelegate(styles, "div").apply {
            -"&"
        }
        assertThat(printer.print(tag)).isEqualTo("<div>%26</div>")
    }
}
