package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap

class BorderProperty(
    map: OrderedMap,
    delegate: ShorthandPropertyDelegate = ShorthandPropertyDelegate("border", map)
) : ShorthandProperty by delegate {
    val style = BorderStyleProperty(map)
    val radius = DimensionProperty("border-radius", map)
}
