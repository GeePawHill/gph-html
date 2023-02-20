package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.css.enums.GenericEnum.none
import org.geepawhill.html.model.Element.Companion.flat
import org.junit.jupiter.api.Test

class RuleDelegateTest {
    val styles = StylesDelegate()
    val declarations = RuleDelegate(styles, "*")

    @Test
    fun `empty selector works`() {
        assertThat(declarations.flat).isEqualTo("* { }")
    }

    @Test
    fun `direct set works`() {
        declarations.apply {
            property["width"] = "10px"
        }
        assertThat(declarations.flat).isEqualTo("* { width: 10px; }")
    }

    @Test
    fun `display field works`() {
        declarations.apply {
            display += none
        }
        assertThat(declarations.flat).isEqualTo("* { display: none; }")
    }

    @Test
    fun `flat output is correct`() {
        declarations.apply {
            display += none
        }
        assertThat(declarations.flat).isEqualTo("* { display: none; }")
    }
}
