package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap

class TextDecorationDeclaration(val map: OrderedMap) {
    var value: String by map.field("text-decoration")

    operator fun plusAssign(new: String) {
        value = new
    }

    operator fun plusAssign(new: TextDecorationEnum) {
        value = new.value
    }
}
