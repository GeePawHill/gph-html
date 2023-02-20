package org.geepawhill.html.css

import org.geepawhill.html.css.enums.AlignmentEnum.left
import org.geepawhill.html.css.enums.AlignmentEnum.right
import org.geepawhill.html.css.enums.CenterEnum.center
import org.geepawhill.html.css.enums.GenericEnum.inherit
import org.geepawhill.html.css.enums.GenericEnum.unset
import org.junit.jupiter.api.Test

class AlignItemsPropertyTest {
    val checker = CssFieldChecker()

    @Test
    fun `accepts all values`() {
        checker.checking("align-items") {
            shouldGet("center") { align_items += center }
            shouldGet("left") { align_items += left }
            shouldGet("right") { align_items += right }
            shouldGet("unset") { align_items += unset }
            shouldGet("inherit") { align_items += inherit }
        }
    }
}
