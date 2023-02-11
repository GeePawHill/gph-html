package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.builder.BasicPrettyPrinter
import org.geepawhill.html.builder.FlatPrinter
import org.geepawhill.html.css.DisplayEnum.none
import org.geepawhill.html.model.Element.Companion.flat
import org.junit.jupiter.api.Test

class StylesDelegateTest {

    val printer = FlatPrinter()

    @Test
    fun `can add selector`() {
        val stylesheet = StylesDelegate()
        stylesheet.apply {
            selector("*") {
                display += none
            }
        }
        assertThat(printer.print(stylesheet)).isEqualTo("<style>*{display: none;}</style>")
        println(BasicPrettyPrinter().print(stylesheet))
    }

    @Test
    fun `formats flat`() {
        val stylesheet = StylesDelegate()
        stylesheet.apply {
            selector("*") {
                display += none
            }
        }
        assertThat(stylesheet.flat).isEqualTo("<style> * { display: none; }</style>")
    }
}
