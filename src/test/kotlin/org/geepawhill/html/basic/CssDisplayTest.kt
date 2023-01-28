package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.basic.BasicOrderedMap.Companion.NO_VALUE
import org.geepawhill.html.css.CssSelector
import org.geepawhill.html.map.MapVal
import org.geepawhill.html.map.MapVar
import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.model.CssField
import org.junit.jupiter.api.Test

class CssDisplay(override val map: OrderedMap) : CssField {
    override var value: String by MapVar("display")
    val none: String by MapVal("display", "none")
    val inline: String by MapVal("display", "inline")

    init {
        value = NO_VALUE
    }
}

class TestingDisplay : CssSelector by BasicCssSelector("*") {
    val display = CssDisplay(attributes)
}

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
