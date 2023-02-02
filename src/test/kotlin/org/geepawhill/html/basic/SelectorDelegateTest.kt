package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.builder.FlatPrinter
import org.geepawhill.html.css.DisplayEnum.none
import org.junit.jupiter.api.Test

class SelectorDelegateTest {
    val printer = FlatPrinter()
    val selector = SelectorDelegate("*")

    @Test
    fun `empty selector works`() {
        assertThat(printer.print(selector)).isEqualTo("*{}")
    }

    @Test
    fun `direct set works`() {
        selector.apply {
            declarations["width"] = "10px"
        }
        assertThat(printer.print(selector)).isEqualTo("*{width: 10px;}")
    }

    @Test
    fun `display field works`() {
        selector.apply {
            display += none
        }
        assertThat(printer.print(selector)).isEqualTo("*{display: none;}")
    }
}
