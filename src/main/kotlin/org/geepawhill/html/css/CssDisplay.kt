package org.geepawhill.html.css

import org.geepawhill.html.map.MapConstant
import org.geepawhill.html.map.MappedField
import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.map.OrderedMap.Companion.NO_VALUE
import org.geepawhill.html.model.CssField

class CssDisplay(override val map: OrderedMap) : CssField {
    override var value: String by MappedField("display", map)
    val none: String by MapConstant("display", "none", map)
    val inline: String by MapConstant("display", "inline", map)
    val block: String by MapConstant("display", "block", map)

    init {
        value = NO_VALUE
    }
}
