package org.geepawhill.html.css

import org.geepawhill.html.css.enums.GenericEnum
import org.geepawhill.html.css.enums.PositionTypeEnum
import org.geepawhill.html.map.OrderedMap

class PositionTypeDeclaration(map: OrderedMap) {
    var value by map.field("position")

    operator fun plusAssign(new: String) {
        value = new
    }

    operator fun plusAssign(new: PositionTypeEnum) {
        value = new.value
    }

    operator fun plusAssign(new: GenericEnum) {
        value = new.value
    }
}
