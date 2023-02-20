package org.geepawhill.html.css

import org.geepawhill.html.css.enums.GenericEnum
import org.geepawhill.html.map.OrderedMap

class TypedPropertyDelegate<TYPE>(
    key: String,
    map: OrderedMap
) : TypedProperty<TYPE> {
    override var value by map.field(key)

    override operator fun plusAssign(raw: String) {
        value = raw
    }

    override operator fun plusAssign(universal: GenericEnum) {
        value = universal.toString()
    }

    override operator fun plusAssign(safe: TYPE) {
        value = safe.toString()
    }
}
