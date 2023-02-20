package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap

class TransitionDeclaration(
    map: OrderedMap,
    delegate: CssShorthandPropertyDelegate = CssShorthandPropertyDelegate("transition", map)
) : CssShorthandProperty by delegate {
    val duration = CssSimpleProperty("duration", map)
}
