package org.geepawhill.html.css

import org.geepawhill.html.css.enums.BorderStyleEnum.dashed
import org.geepawhill.html.css.enums.BorderStyleEnum.dotted
import org.geepawhill.html.css.enums.BorderStyleEnum.double
import org.geepawhill.html.css.enums.BorderStyleEnum.groove
import org.geepawhill.html.css.enums.BorderStyleEnum.hidden
import org.geepawhill.html.css.enums.BorderStyleEnum.inset
import org.geepawhill.html.css.enums.BorderStyleEnum.outset
import org.geepawhill.html.css.enums.BorderStyleEnum.ridge
import org.geepawhill.html.css.enums.BorderStyleEnum.solid
import org.geepawhill.html.css.enums.GenericEnum.inherit
import org.geepawhill.html.css.enums.GenericEnum.initial
import org.geepawhill.html.css.enums.GenericEnum.none
import org.geepawhill.html.css.enums.GenericEnum.unset
import org.junit.jupiter.api.Test

class BorderDeclarationTest {
    val checker = CssFieldChecker()

    @Test
    fun `one of each type in direct`() {
        checker.checking("border") {
            shouldGet("anything") { border += "anything" }
            shouldGet("none") { border += none }
        }
    }

    @Test
    fun `all style options`() {
        checker.checking("border-style") {
            shouldGet("anything") { border.style += "anything" }
            shouldGet("hidden") { border.style += hidden }
            shouldGet("dotted") { border.style += dotted }
            shouldGet("dashed") { border.style += dashed }
            shouldGet("solid") { border.style += solid }
            shouldGet("double") { border.style += double }
            shouldGet("groove") { border.style += groove }
            shouldGet("ridge") { border.style += ridge }
            shouldGet("inset") { border.style += inset }
            shouldGet("outset") { border.style += outset }
            shouldGet("none") { border.style += none }
            shouldGet("unset") { border.style += unset }
            shouldGet("initial") { border.style += initial }
            shouldGet("inherit") { border.style += inherit }
        }
    }

    @Test
    fun `border-radius`() {
        checker.checking("border-radius") {
            shouldGet("anything") { border.radius += "anything" }
            shouldGet("25px") { border.radius += 25.px }
        }
    }
}
