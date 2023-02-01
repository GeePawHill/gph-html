package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.builder.BasicPrettyPrinter
import org.geepawhill.html.builder.FlatPrinter
import org.junit.jupiter.api.Test

class BasicCssStylesheetTest {

    val printer = FlatPrinter()

    @Test
    fun `can add selector`() {
        val stylesheet = BasicCssStylesheet()
        stylesheet.apply {
            selector("*") {
                display.none
            }
        }
        assertThat(printer.print(stylesheet)).isEqualTo("<stylesheet>*{display: none;}</stylesheet>")
        println(BasicPrettyPrinter().print(stylesheet))
    }
}
