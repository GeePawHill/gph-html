package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap

class BoxSizingDeclaration(val map: OrderedMap) {
    var value: String by map.field("box-sizing")

    operator fun plusAssign(new: String) {
        value = new
    }

    operator fun plusAssign(new: BoxSizingEnum) {
        value = new.value
    }
}
