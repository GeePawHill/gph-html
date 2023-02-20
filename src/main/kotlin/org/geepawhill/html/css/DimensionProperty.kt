package org.geepawhill.html.css

import org.geepawhill.html.css.enums.DimensionEnum
import org.geepawhill.html.map.OrderedMap

class DimensionProperty(
    key: String,
    map: OrderedMap,
    delegate: TypedPropertyDelegate<DimensionEnum> = TypedPropertyDelegate(key, map)
) : TypedProperty<DimensionEnum> by delegate
