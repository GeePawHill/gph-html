package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap

class FourSidedDeclaration(key: String, map: OrderedMap) {
    var value by map.field(key)
    var top by map.field("$key-top")
    var bottom by map.field("$key-bottom")
    var left by map.field("$key-left")
    var right by map.field("$key-right")

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
