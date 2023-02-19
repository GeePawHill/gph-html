package org.geepawhill.html.css

import org.geepawhill.html.css.enums.GenericEnum
import org.geepawhill.html.map.OrderedMap

open class CssSimpleProperty(key: String, map: OrderedMap) {
    var value: String by map.field(key)
        private set

    operator fun plusAssign(new: String) {
        value = new
    }

    operator fun plusAssign(universal: GenericEnum) {
        value = universal.toString()
    }
}
