package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.builder.FlatPrinter
import org.junit.jupiter.api.Test

class BasicCssSelectorTest {
    val printer = FlatPrinter()
    val selector = BasicCssSelector("*")

    @Test
    fun `empty selector works`() {
        assertThat(printer.print(selector)).isEqualTo("*{}")
    }

    @Test
    fun `direct set works`() {
        selector.apply {
            attributes["width"] = "10px"
        }
        assertThat(printer.print(selector)).isEqualTo("*{width: 10px;}")
    }

    @Test
    fun `display field works`() {
        selector.apply {
            display.none
        }
        assertThat(printer.print(selector)).isEqualTo("*{display: none;}")
    }
}
