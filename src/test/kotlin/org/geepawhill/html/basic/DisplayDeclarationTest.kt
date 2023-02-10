package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.css.DisplayDeclaration
import org.geepawhill.html.css.DisplayEnum.inline
import org.geepawhill.html.css.DisplayEnum.none
import org.geepawhill.html.css.Selector
import org.geepawhill.html.css.Styles
import org.geepawhill.html.map.OrderedMapDelegate
import org.junit.jupiter.api.Test

class TestingDisplay(styles: Styles) : Selector by SelectorDelegate(styles, "*")

class DisplayDeclarationTest {
    val map = OrderedMapDelegate()
    val display = DisplayDeclaration(map)

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
        val styles = StylesDelegate()
        val thing = TestingDisplay(styles)
        thing.declarations["display"] = "anything"
        thing.apply {
            display += inline
        }
        assertThat(thing.declarations["display"]).isEqualTo("inline")
    }
}
