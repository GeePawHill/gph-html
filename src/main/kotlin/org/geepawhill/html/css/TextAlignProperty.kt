package org.geepawhill.html.css

import org.geepawhill.html.css.enums.AlignmentEnum
import org.geepawhill.html.css.enums.CenterEnum
import org.geepawhill.html.map.OrderedMap

class TextAlignProperty(
    map: OrderedMap,
    delegate: TypedProperty<AlignmentEnum> = TypedPropertyDelegate("text-align", map)
) : TypedProperty<AlignmentEnum> by delegate {

    operator fun plusAssign(safe: CenterEnum) {
        this += safe.toString()
    }
}
