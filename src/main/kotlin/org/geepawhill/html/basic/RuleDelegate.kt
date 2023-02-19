package org.geepawhill.html.basic

import org.geepawhill.html.css.BorderDeclaration
import org.geepawhill.html.css.BoxSizingDeclaration
import org.geepawhill.html.css.ColorDeclaration
import org.geepawhill.html.css.CssSafeProperty
import org.geepawhill.html.css.CssSafePropertyDelegate
import org.geepawhill.html.css.DimensionDeclaration
import org.geepawhill.html.css.DisplayDeclaration
import org.geepawhill.html.css.FloatDeclaration
import org.geepawhill.html.css.FourSidedDeclaration
import org.geepawhill.html.css.PositionDeclaration
import org.geepawhill.html.css.Rule
import org.geepawhill.html.css.Styles
import org.geepawhill.html.css.TextDecorationDeclaration
import org.geepawhill.html.css.VerticalAlignDeclaration
import org.geepawhill.html.css.enums.AlignItemsEnum
import org.geepawhill.html.css.enums.CursorEnum
import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.map.OrderedMapDelegate
import org.geepawhill.html.model.HtmlFormatter

class RuleDelegate(
    val styles: Styles,
    override val rule: String,
) : Rule {

    override val declarations: OrderedMap = OrderedMapDelegate()
    override val display = DisplayDeclaration("display", declarations)
    override val box_sizing = BoxSizingDeclaration("box-sizing", declarations)
    override val text_decoration = TextDecorationDeclaration("text-decoration", declarations)
    override val margin: FourSidedDeclaration = FourSidedDeclaration("margin", declarations)
    override val padding: FourSidedDeclaration = FourSidedDeclaration("padding", declarations)
    override val height: DimensionDeclaration = DimensionDeclaration("height", declarations)
    override val color: ColorDeclaration = ColorDeclaration("color", declarations)
    override val font_size: DimensionDeclaration = DimensionDeclaration("font-size", declarations)
    override val width: DimensionDeclaration = DimensionDeclaration("width", declarations)
    override val background_color: ColorDeclaration = ColorDeclaration("background-color", declarations)
    override val line_height: DimensionDeclaration = DimensionDeclaration("line-height", declarations)
    override val position: PositionDeclaration = PositionDeclaration(declarations)
    override val float: FloatDeclaration = FloatDeclaration("float", declarations)
    override val border: BorderDeclaration = BorderDeclaration(declarations)
    override val vertical_align: VerticalAlignDeclaration = VerticalAlignDeclaration(declarations)
    override val cursor: CssSafeProperty<CursorEnum> = CssSafePropertyDelegate("cursor", declarations)
    override val align_items: CssSafeProperty<AlignItemsEnum> = CssSafePropertyDelegate("align-items", declarations)

    override fun format(formatter: HtmlFormatter): HtmlFormatter {
        formatter.startRule(rule)
        for (declaration in declarations.entries) formatter.declaration(declaration)
        formatter.endRule()
        return formatter
    }
}
