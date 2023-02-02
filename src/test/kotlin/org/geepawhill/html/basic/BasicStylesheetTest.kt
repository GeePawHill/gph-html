package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.builder.BasicPrettyPrinter
import org.geepawhill.html.builder.FlatPrinter
import org.geepawhill.html.css.DisplayEnum.none
import org.junit.jupiter.api.Test

class BasicStylesheetTest {

    val printer = FlatPrinter()

    @Test
    fun `can add selector`() {
        val stylesheet = StylesheetDelegate()
        stylesheet.apply {
            selector("*") {
                display += none
            }
        }
        assertThat(printer.print(stylesheet)).isEqualTo("<style>*{display: none;}</style>")
        println(BasicPrettyPrinter().print(stylesheet))
    }
}
