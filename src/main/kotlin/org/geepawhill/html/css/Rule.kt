package org.geepawhill.html.css

import org.geepawhill.html.basic.TextTransformEnum
import org.geepawhill.html.css.enums.CursorEnum
import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.model.Element

@Suppress("VariableNaming")
interface Rule : Element {
    val rule: String
    val property: OrderedMap
    val display: DisplayProperty
    val box_sizing: BoxSizingProperty
    val text_decoration: TextDecorationProperty
    val margin: FourSidedDeclaration
    val padding: FourSidedDeclaration
    val width: DimensionProperty
    val height: DimensionProperty
    val color: ColorProperty

    val font: FontProperty
    val font_size: DimensionProperty
    val background_color: ColorProperty
    val line_height: DimensionProperty
    val position: PositionProperty
    val float: FloatProperty
    val border: BorderProperty
    val vertical_align: VerticalAlignProperty
    val cursor: TypedProperty<CursorEnum>
    val align_items: AlignItemsProperty
    val text_align: TextAlignProperty
    val transition: TransitionProperty

    val Number.cm: String get() = "${this}cm"
    val Number.mm: String get() = "${this}mm"
    val Number.inch: String get() = "${this}in"
    val Number.px: String get() = "${this}px"
    val Number.pt: String get() = "${this}pt"
    val Number.pc: String get() = "${this}pc"

    val Number.em: String get() = "${this}em"
    val Number.ex: String get() = "${this}ex"
    val Number.ch: String get() = "${this}ch"
    val Number.rem: String get() = "${this}rem"
    val Number.vw: String get() = "${this}vw"
    val Number.vh: String get() = "${this}vh"
    val Number.vmin: String get() = "${this}vmin"
    val Number.vmax: String get() = "${this}vmax"
    val Number.percent: String get() = "$this%"
    val font_weight: FontWeightProperty
    val justify_content: JustifyContentProperty
    val text_transform: TypedProperty<TextTransformEnum>
}
