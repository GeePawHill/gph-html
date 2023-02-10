package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.builder.FlatPrinter
import org.geepawhill.html.css.DisplayEnum.none
import org.junit.jupiter.api.Test

class DeclarationsDelegateTest {
    val styles = StylesDelegate()
    val selector = SelectorDelegate(styles, "*")
    val printer = FlatPrinter()

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
