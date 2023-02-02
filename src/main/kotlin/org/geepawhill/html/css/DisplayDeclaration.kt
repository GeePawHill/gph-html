package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap

@Suppress("VariableNaming")
class DisplayDeclaration(val map: OrderedMap) {
    var value: String by map.field("display")

    operator fun plusAssign(new: String) {
        value = new
    }

    operator fun plusAssign(new: DisplayEnum) {
        value = new.value
    }
}
