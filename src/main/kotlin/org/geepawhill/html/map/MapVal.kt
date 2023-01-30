package org.geepawhill.html.map

import kotlin.reflect.KProperty

class MapVal(private val key: String, private val value: String, val map: OrderedMap) {
    operator fun <RECEIVER> getValue(field: RECEIVER, property: KProperty<*>): String {
        map[key] = value
        return value
    }
}
