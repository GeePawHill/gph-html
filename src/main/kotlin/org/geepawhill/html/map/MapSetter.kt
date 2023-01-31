package org.geepawhill.html.map

import kotlin.reflect.KProperty

/**
 * MapSetter is an interface for a class implementing a property delegate.
 * The interface is introduced to avoid binding OrderedMap to a concrete implementation.
 */

interface MapSetter {
    operator fun <RECEIVER> getValue(field: RECEIVER, property: KProperty<*>): String

    operator fun <RECEIVER> setValue(field: RECEIVER, property: KProperty<*>, value: String)
}
