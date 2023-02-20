package org.geepawhill.html.css

import org.geepawhill.html.css.enums.DisplayEnum
import org.geepawhill.html.map.OrderedMap

class DisplayProperty(
    map: OrderedMap,
    delegate: TypedPropertyDelegate<DisplayEnum> = TypedPropertyDelegate("display", map)
) : TypedProperty<DisplayEnum> by delegate
