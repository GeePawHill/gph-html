package org.geepawhill.html.map

import kotlin.reflect.KProperty

/**
 * A `MapField` is a property delegate for declaring string fields in a class, but storing
 * those fields and values in an `OrderedMap` instead of a backing field.
 *
 * A typical usage would be:
 *
 *      class Something {
 *          private val map = BasicOrderedMap()
 *          var name:String by map.field("key")
 *      }
 *
 * Users can assign to and dereference the value of `name`, which is actually stored in the
 * map under the key "key".
 *
 * _Note: Most actual usages in the library use the same name and key, but any class derived
 * from [AttributeOnlyTag](org.geepawhill.html.model.AttributeOnlyTag) has a mapped field named
 * `classes` which is stored in the map as "class",
 * because `class` is a reserved word._
 *
 */

interface MapField {
    /**
     * Reads the value of the field from the map, indexed by the key.
     *
     * @param RECEIVER is required, but is unused.
     * @param property is required but is unused.
     */
    operator fun <RECEIVER> getValue(field: RECEIVER, property: KProperty<*>): String

    /**
     * Assigns the value of the field to the map, indexed by the key.
     *
     * @param RECEIVER is required, but is unused.
     * @param property is required but is unused.
     */
    operator fun <RECEIVER> setValue(field: RECEIVER, property: KProperty<*>, value: String)
}
