package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap

class PositionDeclaration(map: OrderedMap) {
    val type = PositionTypeDeclaration("position", map)
    val right = DimensionDeclaration("right", map)
    val left = DimensionDeclaration("left", map)
    val bottom = DimensionDeclaration("bottom", map)
    val top = DimensionDeclaration("top", map)
}
