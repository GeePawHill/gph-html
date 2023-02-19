package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap

class TransitionDeclaration(map: OrderedMap) {
    val shorthand = CssSimpleProperty("transition", map)
    val duration = CssSimpleProperty("duration", map)
}
