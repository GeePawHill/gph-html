package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap

class PositionProperty(
    map: OrderedMap,
    delegate: ShorthandPropertyDelegate = ShorthandPropertyDelegate("position", map)
) : ShorthandProperty by delegate {
    val right = DimensionProperty("right", map)
    val left = DimensionProperty("left", map)
    val bottom = DimensionProperty("bottom", map)
    val top = DimensionProperty("top", map)
}
