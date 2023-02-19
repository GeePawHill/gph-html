package org.geepawhill.html.css

import org.geepawhill.html.css.enums.GenericEnum
import org.geepawhill.html.map.OrderedMap

class BorderDeclaration(map: OrderedMap) {
    var value by map.field("border")
        private set

    val style = BorderStyleDeclaration("border-style", map)
    val radius = DimensionDeclaration("border-radius", map)

    operator fun plusAssign(new: String) {
        value = new
    }

    operator fun plusAssign(new: GenericEnum) {
        value = new.toString()
    }
}
