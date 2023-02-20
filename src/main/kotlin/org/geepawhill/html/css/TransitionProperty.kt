package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap

class TransitionProperty(
    map: OrderedMap,
    delegate: ShorthandPropertyDelegate = ShorthandPropertyDelegate("transition", map)
) : ShorthandProperty by delegate {
    val duration = StringProperty("duration", map)
}
