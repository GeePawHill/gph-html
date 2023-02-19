package org.geepawhill.html.css

import org.geepawhill.html.css.enums.FontWeightEnum.normal
import org.geepawhill.html.css.enums.GenericEnum.inherit
import org.junit.jupiter.api.Test

class FontPropertyTest {
    val checker = CssFieldChecker()

    @Test
    fun `weight accepts all value types`() {
        checker.checking("font-weight") {
            shouldGet("300") { font.weight += 300 }
            shouldGet("normal") { font.weight += normal }
            shouldGet("inherit") { font.weight += inherit }
        }
    }
}
