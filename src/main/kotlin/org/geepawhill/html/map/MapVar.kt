package org.geepawhill.html.map

import org.geepawhill.html.model.CssField
import kotlin.reflect.KProperty

class MapVar(private val key: String) {
    operator fun <RECEIVER : CssField> getValue(field: RECEIVER, property: KProperty<*>): String {
        return field.map[key]!!
    }

    operator fun <RECEIVER : CssField> setValue(field: RECEIVER, property: KProperty<*>, value: String) {
        field.map[key] = value
    }
}
