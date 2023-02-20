package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap

class FontProperty(
    map: OrderedMap,
    delegate: ShorthandPropertyDelegate = ShorthandPropertyDelegate("font", map)
) : ShorthandProperty by delegate {
    val size = DimensionDeclaration("font-size", map)
    val weight = FontWeightProperty(map)
}
