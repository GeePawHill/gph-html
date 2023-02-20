package org.geepawhill.html.css

import org.geepawhill.html.css.enums.TextDecorationEnum
import org.geepawhill.html.map.OrderedMap

class TextDecorationProperty(
    map: OrderedMap,
    delegate: TypedPropertyDelegate<TextDecorationEnum> = TypedPropertyDelegate("text-decoration", map)
) : TypedProperty<TextDecorationEnum> by delegate
