package org.geepawhill.html.css

import org.geepawhill.html.css.enums.DimensionEnum
import org.geepawhill.html.css.enums.VerticalAlignEnum
import org.geepawhill.html.map.OrderedMap

class VerticalAlignProperty(
    map: OrderedMap,
    delegate: TypedProperty<DimensionEnum> = TypedPropertyDelegate<DimensionEnum>("vertical-align", map)
) : TypedProperty<DimensionEnum> by delegate {
    operator fun plusAssign(safe: VerticalAlignEnum) {
        this += safe.toString()
    }
}
