package org.geepawhill.html.model

interface AttributeTag : Element {
    val attributes: OrderedMap
    val tag: String
}
