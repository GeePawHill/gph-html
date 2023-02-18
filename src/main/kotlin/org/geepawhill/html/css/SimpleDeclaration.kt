package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.map.OrderedMap.Companion.NO_VALUE

class SimpleDeclaration(map: OrderedMap, key: String, initial: String = NO_VALUE) {
    var value by map.field(key)

    operator fun plusAssign(new: String) {
        value = new
    }

    init {
        value = initial
    }
}
