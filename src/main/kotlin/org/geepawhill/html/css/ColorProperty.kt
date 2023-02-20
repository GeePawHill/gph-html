package org.geepawhill.html.css

import org.geepawhill.html.css.enums.ColorEnum
import org.geepawhill.html.map.OrderedMap
import java.util.*

class ColorProperty(
    key: String,
    map: OrderedMap,
    delegate: TypedProperty<ColorEnum> = TypedPropertyDelegate<ColorEnum>(key, map)
) : TypedProperty<ColorEnum> by delegate {
    operator fun plusAssign(new: Int) {
        this += String.format(Locale.getDefault(), "#%06x", new)
    }
}
