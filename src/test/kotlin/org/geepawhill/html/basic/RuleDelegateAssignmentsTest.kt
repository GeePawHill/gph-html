package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.css.Rule
import org.geepawhill.html.css.enums.DimensionEnum.auto
import org.geepawhill.html.css.enums.GenericEnum.inherit
import org.geepawhill.html.css.enums.GenericEnum.initial
import org.junit.jupiter.api.Test

class RuleDelegateAssignmentsTest {

    val rule = RuleDelegate(StylesDelegate(), "*")

    class Checking(val useRule: Rule, val key: String) {
        fun shouldGet(expected: String, running: Rule.() -> Unit) {
            with(useRule) {
                running()
                assertThat(declarations[key]).isEqualTo(expected)
            }
        }
    }

    fun checking(key: String, checks: Checking.() -> Unit) {
        val check = Checking(rule, key)
        check.checks()
    }

    @Test
    fun `width assignments`() {
        checking("width") {
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
}
