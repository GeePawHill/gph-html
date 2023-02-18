package org.geepawhill.html.css

import org.geepawhill.html.css.enums.GenericEnum
import org.geepawhill.html.map.OrderedMap
import java.util.*

class ColorDeclaration(key: String, map: OrderedMap) {
    var value: String by map.field(key)

    operator fun plusAssign(new: String) {
        value = new
    }

    operator fun plusAssign(new: GenericEnum) {
        value = new.value
    }

    operator fun plusAssign(new: Int) {
        value = String.format(Locale.getDefault(), "#%06x", new)
    }
}
