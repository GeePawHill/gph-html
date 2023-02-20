package org.geepawhill.html.css

import org.geepawhill.html.css.enums.FontWeightEnum
import org.geepawhill.html.map.OrderedMap

class FontWeightProperty(
    map: OrderedMap,
    delegate: TypedProperty<FontWeightEnum> = TypedPropertyDelegate<FontWeightEnum>("font-weight", map)
) : TypedProperty<FontWeightEnum> by delegate {
    operator fun plusAssign(number: Int) {
        this += number.toString()
    }
}
