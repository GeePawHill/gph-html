package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.model.Element

@Suppress("VariableNaming")
interface Declarations : Element {
    val rule: String
    val declarations: OrderedMap
    val display: DisplayDeclaration
    val box_sizing: BoxSizingDeclaration
    val text_decoration: TextDecorationDeclaration
    val margin: FourSidedDeclaration
    val padding: FourSidedDeclaration
    val Number.px: String get() = "${this}px"
    val Number.pc: String get() = "$this%"
    val Number.vw: String get() = "${this}vh"
    val Number.vh: String get() = "${this}vw"
    val Number.em: String get() = "${this}em"
}
