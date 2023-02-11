package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.builder.FlatPrinter
import org.geepawhill.html.css.DisplayEnum.none
import org.geepawhill.html.model.Element.Companion.flat
import org.junit.jupiter.api.Test

class MediaQueryDelegateTest {
    val printer = FlatPrinter()
    val styles = StylesDelegate()

    @Test
    fun `can construct`() {
        val query = MediaQueryDelegate(styles, "only screen and (min-width: 600px)", "class")
        with(query) {
            display += none
        }
        assertThat(printer.print(query)).isEqualTo("@media only screen and (min-width: 600px) {display: none;}")
    }

    @Test
    fun `formats flat correctly`() {
        val query = MediaQueryDelegate(styles, "only screen and (min-width: 600px)", "rule")
        with(query) {
            display += none
        }
        assertThat(query.flat).isEqualTo("@media only screen and (min-width: 600px) { rule { display: none; } }")
    }
}
