package org.geepawhill.html.basic

import org.geepawhill.html.css.BoxSizingDeclaration
import org.geepawhill.html.css.ColorDeclaration
import org.geepawhill.html.css.DimensionDeclaration
import org.geepawhill.html.css.DisplayDeclaration
import org.geepawhill.html.css.FourSidedDeclaration
import org.geepawhill.html.css.Rule
import org.geepawhill.html.css.Styles
import org.geepawhill.html.css.TextDecorationDeclaration
import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.map.OrderedMapDelegate
import org.geepawhill.html.model.HtmlFormatter

class RuleDelegate(
    val styles: Styles,
    override val rule: String,
) : Rule {

    override val declarations: OrderedMap = OrderedMapDelegate()
    override val display = DisplayDeclaration(declarations)
    override val box_sizing = BoxSizingDeclaration(declarations)
    override val text_decoration = TextDecorationDeclaration(declarations)
    override val margin: FourSidedDeclaration = FourSidedDeclaration("margin", declarations)
    override val padding: FourSidedDeclaration = FourSidedDeclaration("padding", declarations)
    override val height: DimensionDeclaration = DimensionDeclaration("height", declarations)
    override val color: ColorDeclaration = ColorDeclaration("color", declarations)
    override val font_size: DimensionDeclaration = DimensionDeclaration("font-size", declarations)
    override val width: DimensionDeclaration = DimensionDeclaration("width", declarations)

    override fun format(formatter: HtmlFormatter): HtmlFormatter {
        formatter.startRule(rule)
        for (declaration in declarations.entries) formatter.declaration(declaration)
        formatter.endRule()
        return formatter
    }
}
