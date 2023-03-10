package org.geepawhill.html.css

import org.geepawhill.html.css.enums.GenericEnum
import org.geepawhill.html.map.OrderedMap

class ShorthandPropertyDelegate(key: String, map: OrderedMap) : ShorthandProperty {
    override var value: String by map.field(key)

    override fun plusAssign(new: String) {
        value = new
    }

    override fun plusAssign(universal: GenericEnum) {
        this += universal.toString()
    }
}
