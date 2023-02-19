package org.geepawhill.html.css

import org.geepawhill.html.css.BorderStyleEnum.dashed
import org.geepawhill.html.css.BorderStyleEnum.dotted
import org.geepawhill.html.css.BorderStyleEnum.double
import org.geepawhill.html.css.BorderStyleEnum.groove
import org.geepawhill.html.css.BorderStyleEnum.hidden
import org.geepawhill.html.css.BorderStyleEnum.inset
import org.geepawhill.html.css.BorderStyleEnum.outset
import org.geepawhill.html.css.BorderStyleEnum.ridge
import org.geepawhill.html.css.BorderStyleEnum.solid
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
}
