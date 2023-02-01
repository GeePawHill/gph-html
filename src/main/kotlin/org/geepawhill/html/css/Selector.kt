package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.model.Element
import org.geepawhill.html.model.HtmlVisitor

interface Selector : Element {
    val declarations: OrderedMap
    override fun accept(visitor: HtmlVisitor)
    val display: DisplayDeclaration
    val rule: String
}
