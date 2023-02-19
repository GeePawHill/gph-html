package org.geepawhill.html.css

import org.geepawhill.html.css.enums.DimensionEnum
import org.geepawhill.html.css.enums.VerticalAlignEnum
import org.geepawhill.html.map.OrderedMap

class VerticalAlignDeclaration(
    map: OrderedMap,
    delegate: CssSafeProperty<DimensionEnum> = CssSafePropertyDelegate<DimensionEnum>("vertical-align", map)
) : CssSafeProperty<DimensionEnum> by delegate {
    operator fun plusAssign(safe: VerticalAlignEnum) {
        this += safe.toString()
    }
}
