package org.geepawhill.html.basic

import org.geepawhill.html.css.CssFieldChecker
import org.geepawhill.html.css.enums.DimensionEnum.auto
import org.geepawhill.html.css.enums.GenericEnum.inherit
import org.geepawhill.html.css.enums.GenericEnum.initial
import org.junit.jupiter.api.Test

class DimensionDeclationTest {

    val checker = CssFieldChecker()

    @Test
    fun `all width assignments`() {
        checker.checking("width") {
            shouldGet("hi mom!") { width += "hi mom!" }
            shouldGet("hello mother!") { declarations["width"] = "hello mother!" }

            shouldGet("100cm") { width += 100.cm }
            shouldGet("100mm") { width += 100.mm }
            shouldGet("100in") { width += 100.inch }
            shouldGet("100px") { width += 100.px }
            shouldGet("100pt") { width += 100.pt }
            shouldGet("100pc") { width += 100.pc }

            shouldGet("100em") { width += 100.em }
            shouldGet("100ex") { width += 100.ex }
            shouldGet("100ch") { width += 100.ch }
            shouldGet("100rem") { width += 100.rem }
            shouldGet("100vw") { width += 100.vw }
            shouldGet("100vh") { width += 100.vh }
            shouldGet("100vmin") { width += 100.vmin }
            shouldGet("100vmax") { width += 100.vmax }
            shouldGet("100%") { width += 100.percent }

            shouldGet("initial") { width += initial }
            shouldGet("inherit") { width += inherit }
            shouldGet("auto") { width += auto }
        }
    }

    @Test
    fun `a couple of height assignments`() {
        checker.checking("height") {
            shouldGet("hi mom!") { height += "hi mom!" }
            shouldGet("hello mother!") { declarations["height"] = "hello mother!" }
            shouldGet("100px") { height += 100.px }
            shouldGet("auto") { height += auto }
        }
    }
}
