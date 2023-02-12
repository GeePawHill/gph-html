package org.geepawhill.html.model

import org.geepawhill.html.map.OrderedMap

interface AttributeOnlyTag : Element {
    val attributes: OrderedMap
    val tag: String
}
