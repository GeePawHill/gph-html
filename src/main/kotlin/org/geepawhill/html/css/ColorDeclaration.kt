package org.geepawhill.html.css

import org.geepawhill.html.css.enums.ColorEnum
import org.geepawhill.html.map.OrderedMap
import java.util.*

class ColorDeclaration(
    key: String,
    map: OrderedMap,
    delegate: CssSafeProperty<ColorEnum> = CssSafePropertyDelegate<ColorEnum>(key, map)
) : CssSafeProperty<ColorEnum> by delegate {
    operator fun plusAssign(new: Int) {
        this += String.format(Locale.getDefault(), "#%06x", new)
    }
}
