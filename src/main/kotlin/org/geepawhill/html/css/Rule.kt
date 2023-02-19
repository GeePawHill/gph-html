package org.geepawhill.html.css

import org.geepawhill.html.css.enums.AlignItemsEnum
import org.geepawhill.html.css.enums.CursorEnum
import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.model.Element

@Suppress("VariableNaming")
interface Rule : Element {
    val rule: String
    val declarations: OrderedMap
    val display: DisplayDeclaration
    val box_sizing: BoxSizingDeclaration
    val text_decoration: TextDecorationDeclaration
    val margin: FourSidedDeclaration
    val padding: FourSidedDeclaration
    val width: DimensionDeclaration
    val height: DimensionDeclaration
    val color: ColorDeclaration

    val font: FontProperty
    val font_size: DimensionDeclaration
    val background_color: ColorDeclaration
    val line_height: DimensionDeclaration
    val position: PositionDeclaration
    val float: FloatDeclaration
    val border: BorderProperty
    val vertical_align: VerticalAlignDeclaration
    val cursor: CssSafeProperty<CursorEnum>
    val align_items: CssSafeProperty<AlignItemsEnum>
    val transition: TransitionDeclaration

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
}
