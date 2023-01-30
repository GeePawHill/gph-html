package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.css.CssDisplay
import org.geepawhill.html.css.CssSelector
import org.geepawhill.html.map.BasicOrderedMap
import org.geepawhill.html.map.OrderedMap.Companion.NO_VALUE
import org.junit.jupiter.api.Test

class TestingDisplay : CssSelector by BasicCssSelector("*")

class CssDisplayTest {
    val map = BasicOrderedMap()
    val display = CssDisplay(map)

    @Test
    fun `no value on init`() {
        assertThat(display.value).isEqualTo(NO_VALUE)
    }

    @Test
    fun `direct setting works`() {
        display.value = "none"
        assertThat(display.value).isEqualTo("none")
        assertThat(map["display"]).isEqualTo("none")
    }

    @Test
    fun `api setting works`() {
        display.none
        assertThat(display.value).isEqualTo("none")
        assertThat(map["display"]).isEqualTo("none")
    }

    @Test
    fun `dsl works`() {
        val thing = TestingDisplay()
        thing.apply {
            display.inline
        }
        assertThat(thing.attributes["display"]).isEqualTo("inline")
    }
}
