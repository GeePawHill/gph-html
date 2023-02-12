package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.css.enums.GenericEnum.none
import org.geepawhill.html.model.Element.Companion.flat
import org.junit.jupiter.api.Test

class MediaQueryDelegateTest {
    val styles = StylesDelegate()

    @Test
    fun `can construct`() {
        val query = MediaQueryDelegate(styles, "only screen and (min-width: 600px)", "class")
        with(query) {
            display += none
        }
        assertThat(query.flat).isEqualTo("@media only screen and (min-width: 600px) { class { display: none; } }")
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
