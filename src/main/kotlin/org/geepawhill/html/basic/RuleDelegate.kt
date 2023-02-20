package org.geepawhill.html.basic

import org.geepawhill.html.css.AlignItemsProperty
import org.geepawhill.html.css.BorderProperty
import org.geepawhill.html.css.BoxSizingProperty
import org.geepawhill.html.css.ColorProperty
import org.geepawhill.html.css.DimensionDeclaration
import org.geepawhill.html.css.DisplayProperty
import org.geepawhill.html.css.FloatDeclaration
import org.geepawhill.html.css.FontProperty
import org.geepawhill.html.css.FontWeightProperty
import org.geepawhill.html.css.FourSidedDeclaration
import org.geepawhill.html.css.JustifyContentProperty
import org.geepawhill.html.css.PositionDeclaration
import org.geepawhill.html.css.Rule
import org.geepawhill.html.css.Styles
import org.geepawhill.html.css.TextAlignProperty
import org.geepawhill.html.css.TextDecorationProperty
import org.geepawhill.html.css.TransitionProperty
import org.geepawhill.html.css.TypedProperty
import org.geepawhill.html.css.TypedPropertyDelegate
import org.geepawhill.html.css.VerticalAlignProperty
import org.geepawhill.html.css.enums.CursorEnum
import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.map.OrderedMapDelegate
import org.geepawhill.html.model.HtmlFormatter

class RuleDelegate(
    val styles: Styles,
    override val rule: String,
) : Rule {

    override val declarations: OrderedMap = OrderedMapDelegate()
    override val display = DisplayProperty("display", declarations)
    override val box_sizing: BoxSizingProperty = BoxSizingProperty(declarations)
    override val text_decoration = TextDecorationProperty(declarations)
    override val margin: FourSidedDeclaration = FourSidedDeclaration("margin", declarations)
    override val padding: FourSidedDeclaration = FourSidedDeclaration("padding", declarations)
    override val height: DimensionDeclaration = DimensionDeclaration("height", declarations)
    override val color: ColorProperty = ColorProperty("color", declarations)
    override val font: FontProperty = FontProperty(declarations)
    override val font_size: DimensionDeclaration = DimensionDeclaration("font-size", declarations)
    override val font_weight: FontWeightProperty = FontWeightProperty(declarations)
    override val width: DimensionDeclaration = DimensionDeclaration("width", declarations)
    override val background_color: ColorProperty = ColorProperty("background-color", declarations)
    override val line_height: DimensionDeclaration = DimensionDeclaration("line-height", declarations)
    override val position: PositionDeclaration = PositionDeclaration(declarations)
    override val float: FloatDeclaration = FloatDeclaration("float", declarations)
    override val border: BorderProperty = BorderProperty(declarations)
    override val vertical_align: VerticalAlignProperty = VerticalAlignProperty(declarations)
    override val cursor: TypedProperty<CursorEnum> = TypedPropertyDelegate("cursor", declarations)
    override val align_items: AlignItemsProperty = AlignItemsProperty(declarations)
    override val text_align: TextAlignProperty = TextAlignProperty(declarations)
    override val transition: TransitionProperty = TransitionProperty(declarations)
    override val justify_content: JustifyContentProperty = JustifyContentProperty(declarations)
    override val text_transform: TypedProperty<TextTransformEnum> =
        TypedPropertyDelegate("text-transform", declarations)

    override fun format(formatter: HtmlFormatter): HtmlFormatter {
        formatter.startRule(rule)
        for (declaration in declarations.entries) formatter.declaration(declaration)
        formatter.endRule()
        return formatter
    }
}
