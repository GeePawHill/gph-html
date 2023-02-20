package org.geepawhill.html.css

import org.geepawhill.html.css.enums.BorderStyleEnum
import org.geepawhill.html.map.OrderedMap

class BorderStyleProperty(
    map: OrderedMap,
    delegate: TypedPropertyDelegate<BorderStyleEnum> = TypedPropertyDelegate("border-style", map)
) : TypedProperty<BorderStyleEnum> by delegate
