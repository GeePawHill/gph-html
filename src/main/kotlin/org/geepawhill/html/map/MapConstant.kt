package org.geepawhill.html.map

import kotlin.reflect.KProperty

interface MapConstant {
    operator fun <RECEIVER> getValue(field: RECEIVER, property: KProperty<*>): String
}
