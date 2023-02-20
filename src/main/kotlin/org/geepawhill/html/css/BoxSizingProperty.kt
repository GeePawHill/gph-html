package org.geepawhill.html.css

import org.geepawhill.html.css.enums.BoxSizingEnum
import org.geepawhill.html.map.OrderedMap

class BoxSizingProperty(
    map: OrderedMap,
    delegate: TypedPropertyDelegate<BoxSizingEnum> = TypedPropertyDelegate("box-sizing", map)
) : TypedProperty<BoxSizingEnum> by delegate
