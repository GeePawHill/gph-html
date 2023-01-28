package org.geepawhill.html.map

import org.geepawhill.html.model.CssField
import kotlin.reflect.KProperty

class MapVal(private val key: String, private val value: String) {
    operator fun <RECEIVER : CssField> getValue(field: RECEIVER, property: KProperty<*>): String {
        field.map[key] = value
        return value
    }
}
