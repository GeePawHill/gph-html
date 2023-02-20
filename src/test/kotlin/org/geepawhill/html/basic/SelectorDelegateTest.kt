package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.css.DisplayProperty
import org.geepawhill.html.css.enums.DisplayEnum.inline
import org.geepawhill.html.css.enums.GenericEnum.none
import org.geepawhill.html.map.OrderedMapDelegate
import org.geepawhill.html.model.Element.Companion.flat
import org.junit.jupiter.api.Test

class SelectorDelegateTest {
    val map = OrderedMapDelegate()
    val display = DisplayProperty("display", map)
    val styles = StylesDelegate()

    @Test
    fun `direct setting works`() {
        display.value = "none"
        assertThat(display.value).isEqualTo("none")
        assertThat(map["display"]).isEqualTo("none")
    }

    @Test
    fun `api setting works`() {
        display += none
        assertThat(display.value).isEqualTo("none")
        assertThat(map["display"]).isEqualTo("none")
    }

    @Test
    fun `dsl works`() {
        val thing = SelectorDelegate(styles, "*")
        thing.declarations["display"] = "anything"
        thing.apply {
            display += inline
        }
        assertThat(thing.declarations["display"]).isEqualTo("inline")
    }

    @Test
    fun `flat format is correct`() {
        val selector = SelectorDelegate(styles, "*")
        selector.apply {
            display += inline
        }
        assertThat(selector.flat).isEqualTo(" * { display: inline; }")
    }
}
