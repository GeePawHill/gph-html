package org.geepawhill.html.css

import org.geepawhill.html.css.enums.GenericEnum
import org.geepawhill.html.map.OrderedMap

class BorderStyleDeclaration(map: OrderedMap) {
    var value by map.field("border-style")
        private set

    operator fun plusAssign(new: String) {
        value = new
    }

    operator fun plusAssign(new: BorderStyleEnum) {
        value = new.value
    }

    operator fun plusAssign(new: GenericEnum) {
        value = new.value
    }
}
