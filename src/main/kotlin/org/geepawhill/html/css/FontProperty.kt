package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap

class FontProperty(
    map: OrderedMap,
    delegate: CssShorthandPropertyDelegate = CssShorthandPropertyDelegate("font", map)
) : CssShorthandProperty by delegate {
    val size = DimensionDeclaration("font-size", map)
}
