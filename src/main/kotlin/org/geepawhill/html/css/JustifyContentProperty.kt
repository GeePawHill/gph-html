package org.geepawhill.html.css

import org.geepawhill.html.css.enums.CenterEnum
import org.geepawhill.html.css.enums.JustifyContentEnum
import org.geepawhill.html.map.OrderedMap

class JustifyContentProperty(
    map: OrderedMap,
    delegate: TypedProperty<JustifyContentEnum> = TypedPropertyDelegate("justify-content", map)
) : TypedProperty<JustifyContentEnum> by delegate {
    operator fun plusAssign(center: CenterEnum) {
        this += center.toString()
    }
}
