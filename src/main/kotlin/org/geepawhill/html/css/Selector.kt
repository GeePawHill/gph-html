package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.model.Element
import org.geepawhill.html.model.HtmlVisitor

@Suppress("VariableNaming")
interface Selector : Element {
    val declarations: OrderedMap
    val display: DisplayDeclaration
    val box_sizing: BoxSizingDeclaration
    val rule: String
    val text_decoration: TextDecorationDeclaration
    override fun accept(visitor: HtmlVisitor)
}
