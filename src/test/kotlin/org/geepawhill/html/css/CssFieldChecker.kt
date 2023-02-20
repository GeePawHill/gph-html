package org.geepawhill.html.css

import org.assertj.core.api.Assertions
import org.geepawhill.html.basic.RuleDelegate
import org.geepawhill.html.basic.StylesDelegate

class CssFieldChecker {
    val rule = RuleDelegate(StylesDelegate(), "*")

    class Checking(val useRule: Rule, val key: String) {
        fun shouldGet(expected: String, running: Rule.() -> Unit) {
            with(useRule) {
                running()
                Assertions.assertThat(property[key]).isEqualTo(expected)
            }
        }
    }

    fun checking(key: String, checks: Checking.() -> Unit) {
        val check = Checking(rule, key)
        check.checks()
    }
}
