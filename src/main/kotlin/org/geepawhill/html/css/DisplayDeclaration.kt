package org.geepawhill.html.css

import org.geepawhill.html.css.enums.DisplayEnum
import org.geepawhill.html.css.enums.GenericEnum
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

    operator fun plusAssign(new: GenericEnum) {
        value = new.value
    }
}
