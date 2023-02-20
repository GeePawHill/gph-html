package org.geepawhill.html.basic

import org.geepawhill.html.css.MediaQuery
import org.geepawhill.html.css.Rule
import org.geepawhill.html.css.Selector
import org.geepawhill.html.css.Styles
import org.geepawhill.html.model.HtmlFormatter

class SelectorDelegate(
    val styles: Styles,
    rule: String,
    private val delegate: RuleDelegate = RuleDelegate(styles, rule)
) : Selector,
    Rule by delegate {

    override fun media(query: String, details: MediaQuery.() -> Unit) {
        val new = MediaQueryDelegate(styles, query, rule)
        new.details()
        styles.apply { +new }
    }

    override fun small(details: MediaQuery.() -> Unit) {
        media("only screen and (min-width: 600px)", details)
    }

    override fun medium(details: MediaQuery.() -> Unit) {
        media("only screen and (min-width: 768px)", details)
    }

    override fun large(details: MediaQuery.() -> Unit) {
        media("only screen and (min-width: 992px)", details)
    }

    override fun huge(details: MediaQuery.() -> Unit) {
        media("only screen and (min-width: 1200px)", details)
    }

    override fun format(formatter: HtmlFormatter): HtmlFormatter {
        formatter.openSelector(rule)
        for (declaration in property.entries) formatter.declaration(declaration)
        formatter.closeSelector()
        return formatter
    }
}
