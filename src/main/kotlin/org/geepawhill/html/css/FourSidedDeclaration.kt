package org.geepawhill.html.css

import org.geepawhill.html.basic.SimpleAttribute
import org.geepawhill.html.map.OrderedMap

class FourSidedDeclaration(key: String, map: OrderedMap) {
    var value by map.field(key)
    val zero by map.constant(key, "0")
    val top = SimpleAttribute(map, "$key-top")
    var bottom = SimpleAttribute(map, "$key-bottom")
    var left = SimpleAttribute(map, "$key-left")
    var right = SimpleAttribute(map, "$key-right")

    fun set(vertical: String, horizontal: String) {
        value = "$vertical $horizontal"
    }

    fun set(top: String, horizontal: String, bottom: String) {
        value = "$top $horizontal $bottom"
    }

    fun set(top: String, right: String, bottom: String, left: String) {
        value = "$top $right $bottom $left"
    }
}
