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

    override val property: OrderedMap = OrderedMapDelegate()
    override val display = DisplayProperty("display", property)
    override val box_sizing: BoxSizingProperty = BoxSizingProperty(property)
    override val text_decoration = TextDecorationProperty(property)
    override val margin: FourSidedDeclaration = FourSidedDeclaration("margin", property)
    override val padding: FourSidedDeclaration = FourSidedDeclaration("padding", property)
    override val height: DimensionDeclaration = DimensionDeclaration("height", property)
    override val color: ColorProperty = ColorProperty("color", property)
    override val font: FontProperty = FontProperty(property)
    override val font_size: DimensionDeclaration = DimensionDeclaration("font-size", property)
    override val font_weight: FontWeightProperty = FontWeightProperty(property)
    override val width: DimensionDeclaration = DimensionDeclaration("width", property)
    override val background_color: ColorProperty = ColorProperty("background-color", property)
    override val line_height: DimensionDeclaration = DimensionDeclaration("line-height", property)
    override val position: PositionDeclaration = PositionDeclaration(property)
    override val float: FloatDeclaration = FloatDeclaration("float", property)
    override val border: BorderProperty = BorderProperty(property)
    override val vertical_align: VerticalAlignProperty = VerticalAlignProperty(property)
    override val cursor: TypedProperty<CursorEnum> = TypedPropertyDelegate("cursor", property)
    override val align_items: AlignItemsProperty = AlignItemsProperty(property)
    override val text_align: TextAlignProperty = TextAlignProperty(property)
    override val transition: TransitionProperty = TransitionProperty(property)
    override val justify_content: JustifyContentProperty = JustifyContentProperty(property)
    override val text_transform: TypedProperty<TextTransformEnum> =
        TypedPropertyDelegate("text-transform", property)

    override fun format(formatter: HtmlFormatter): HtmlFormatter {
        formatter.startRule(rule)
        for (declaration in property.entries) formatter.declaration(declaration)
        formatter.endRule()
        return formatter
    }
}
