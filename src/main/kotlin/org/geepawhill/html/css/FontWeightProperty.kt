package org.geepawhill.html.css

import org.geepawhill.html.css.enums.FontWeightEnum
import org.geepawhill.html.map.OrderedMap

class FontWeightProperty(
    map: OrderedMap,
    delegate: CssSafeProperty<FontWeightEnum> = CssSafePropertyDelegate<FontWeightEnum>("font-weight", map)
) : CssSafeProperty<FontWeightEnum> by delegate {
    operator fun plusAssign(number: Int) {
        this += number.toString()
    }
}
