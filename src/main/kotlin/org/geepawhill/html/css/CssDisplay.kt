package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap

class CssDisplay(val map: OrderedMap) {
    var value: String by map.field("display")

    fun none() {
        value = "none"
    }

    fun inline() {
        value = "inline"
    }

    fun block() {
        value = "block"
    }
}
