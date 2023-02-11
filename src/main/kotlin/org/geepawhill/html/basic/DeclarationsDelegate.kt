package org.geepawhill.html.basic

import org.geepawhill.html.css.BoxSizingDeclaration
import org.geepawhill.html.css.Declarations
import org.geepawhill.html.css.DisplayDeclaration
import org.geepawhill.html.css.FourSidedDeclaration
import org.geepawhill.html.css.Styles
import org.geepawhill.html.css.TextDecorationDeclaration
import org.geepawhill.html.formatter.FlatFormatter
import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.map.OrderedMapDelegate
import org.geepawhill.html.model.HtmlFormatter
import org.geepawhill.html.model.HtmlVisitor

class DeclarationsDelegate(
    val styles: Styles,
    override val rule: String,
) : Declarations {

    override val flat: String
        get() = FlatFormatter().apply { format(this) }.toString()

    override val declarations: OrderedMap = OrderedMapDelegate()
    override val display = DisplayDeclaration(declarations)
    override val box_sizing = BoxSizingDeclaration(declarations)
    override val text_decoration = TextDecorationDeclaration(declarations)
    override val margin: FourSidedDeclaration = FourSidedDeclaration("margin", declarations)
    override val padding: FourSidedDeclaration = FourSidedDeclaration("padding", declarations)

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }

    override fun format(formatter: HtmlFormatter) {
        TODO("Not yet implemented")
    }
}
