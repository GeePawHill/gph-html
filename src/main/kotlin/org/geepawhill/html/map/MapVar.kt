package org.geepawhill.html.map

import kotlin.reflect.KProperty

class MapVar(private val key: String, private val map: OrderedMap) {
    operator fun <RECEIVER> getValue(field: RECEIVER, property: KProperty<*>): String {
        return map[key]!!
    }

    operator fun <RECEIVER> setValue(field: RECEIVER, property: KProperty<*>, value: String) {
        map[key] = value
    }
}
