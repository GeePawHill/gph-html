package org.geepawhill.html.basic

import org.geepawhill.html.css.BoxSizingDeclaration
import org.geepawhill.html.css.DisplayDeclaration
import org.geepawhill.html.css.Selector
import org.geepawhill.html.css.TextDecorationDeclaration
import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.map.OrderedMapDelegate
import org.geepawhill.html.model.HtmlVisitor

class SelectorDelegate(
    override val rule: String,
) : Selector {

    override val declarations: OrderedMap = OrderedMapDelegate()
    override val display = DisplayDeclaration(declarations)
    override val box_sizing = BoxSizingDeclaration(declarations)
    override val text_decoration = TextDecorationDeclaration(declarations)

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }
}
