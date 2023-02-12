package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.css.enums.GenericEnum.none
import org.geepawhill.html.model.Element.Companion.flat
import org.junit.jupiter.api.Test

class StylesDelegateTest {

    @Test
    fun `can add selector`() {
        val stylesheet = StylesDelegate()
        stylesheet.apply {
            selector("*") {
                display += none
            }
        }
        assertThat(stylesheet.flat).isEqualTo("<style> * { display: none; }</style>")
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
