package org.geepawhill.html.css

import org.geepawhill.html.basic.FloatEnum
import org.geepawhill.html.map.OrderedMap

class FloatProperty(
    map: OrderedMap,
    delegate: TypedPropertyDelegate<FloatEnum> = TypedPropertyDelegate("float", map)
) : TypedProperty<FloatEnum> by delegate
