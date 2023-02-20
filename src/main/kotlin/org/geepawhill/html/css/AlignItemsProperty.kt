package org.geepawhill.html.css

import org.geepawhill.html.css.enums.AlignItemsEnum
import org.geepawhill.html.css.enums.AlignmentEnum
import org.geepawhill.html.css.enums.CenterEnum
import org.geepawhill.html.map.OrderedMap

class AlignItemsProperty(
    map: OrderedMap,
    delegate: TypedProperty<AlignItemsEnum> = TypedPropertyDelegate("align-items", map)
) : TypedProperty<AlignItemsEnum> by delegate {
    operator fun plusAssign(safe: AlignmentEnum) {
        this += safe.toString()
    }

    operator fun plusAssign(safe: CenterEnum) {
        this += safe.toString()
    }
}
