package org.geepawhill.html.css

import org.geepawhill.html.basic.FloatEnum
import org.geepawhill.html.css.enums.GenericEnum
import org.geepawhill.html.map.OrderedMap

class FloatDeclaration(map: OrderedMap) {
    var value by map.field("float")

    operator fun plusAssign(new: String) {
        value = new
    }

    operator fun plusAssign(new: GenericEnum) {
        value = new.value
    }

    operator fun plusAssign(new: FloatEnum) {
        value = new.value
    }
}
