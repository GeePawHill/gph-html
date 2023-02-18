package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.map.OrderedMap.Companion.NO_VALUE

class ClassDeclaration(initial: String = NO_VALUE, map: OrderedMap) {
    var value by map.field("class")

    operator fun plusAssign(new: String) {
        value = new
    }

    init {
        value = initial
    }
}
