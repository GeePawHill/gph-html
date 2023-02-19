package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap

class BorderProperty(
    map: OrderedMap,
    delegate: CssShorthandPropertyDelegate = CssShorthandPropertyDelegate("border", map)
) : CssShorthandProperty by delegate {
    val style = BorderStyleDeclaration("border-style", map)
    val radius = DimensionDeclaration("border-radius", map)
}
