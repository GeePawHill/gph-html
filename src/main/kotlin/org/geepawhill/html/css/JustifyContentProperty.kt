package org.geepawhill.html.css

import org.geepawhill.html.css.enums.CenterEnum
import org.geepawhill.html.css.enums.JustifyContentEnum
import org.geepawhill.html.map.OrderedMap

class JustifyContentProperty(
    map: OrderedMap,
    delegate: CssSafeProperty<JustifyContentEnum> = CssSafePropertyDelegate("justify-content", map)
) : CssSafeProperty<JustifyContentEnum> by delegate {
    operator fun plusAssign(center: CenterEnum) {
        this += center.toString()
    }
}
