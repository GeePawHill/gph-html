package org.geepawhill.html.map

import kotlin.reflect.KProperty

/**
 * MapConstant is the interface returned by an OrderedMap that allows users to define constant
 * values to be placed in the map at a given key.
 *
 * The actual workers are inner classes in a given implementation of
 * [org.geepawhill.html.map.OrderedMap](OrderedMap)
 *
 * See [org.geepawhill.html.map.OrderedMapDelegate](OrderedMapDelegate) for the worker class
 * definitions.
 *
 * For a sample usage, see [org.geepawhill.html.css.CssDisplay](CssDisplay).
 *
 * IMPORTANT: This is a very strange usage. The resulting code looks like it is a field fetch,
 * but it's actually a field store. Call it a local idiom.
 */
interface MapConstant {
    /**
     * the getValue here is not truly a getter. Invoking it will _store_ the constant into the
     * map that returned the MapConstant at the key it was given when being made.
     *
     */
    operator fun <RECEIVER> getValue(field: RECEIVER, property: KProperty<*>): String
}
