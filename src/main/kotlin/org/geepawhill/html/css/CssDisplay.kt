package org.geepawhill.html.css

import org.geepawhill.html.map.MapVal
import org.geepawhill.html.map.MapVar
import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.map.OrderedMap.Companion.NO_VALUE
import org.geepawhill.html.model.CssField

class CssDisplay(override val map: OrderedMap) : CssField {
    override var value: String by MapVar("display")
    val none: String by MapVal("display", "none")
    val inline: String by MapVal("display", "inline")
    val block: String by MapVal("display", "block")

    init {
        value = NO_VALUE
    }
}
