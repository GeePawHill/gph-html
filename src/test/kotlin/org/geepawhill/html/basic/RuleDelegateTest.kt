package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.builder.FlatPrinter
import org.geepawhill.html.css.DisplayEnum.none
import org.geepawhill.html.model.Element.Companion.flat
import org.junit.jupiter.api.Test

class RuleDelegateTest {
    val styles = StylesDelegate()
    val declarations = RuleDelegate(styles, "*")
    val printer = FlatPrinter()

    @Test
    fun `empty selector works`() {
        assertThat(printer.print(declarations)).isEqualTo("*{}")
    }

    @Test
    fun `direct set works`() {
        declarations.apply {
            declarations["width"] = "10px"
        }
        assertThat(printer.print(declarations)).isEqualTo("*{width: 10px;}")
    }

    @Test
    fun `display field works`() {
        declarations.apply {
            display += none
        }
        assertThat(printer.print(declarations)).isEqualTo("*{display: none;}")
    }

    @Test
    fun `flat output is correct`() {
        declarations.apply {
            display += none
        }
        assertThat(declarations.flat).isEqualTo("* { display: none; }")
    }
}
