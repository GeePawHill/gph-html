package org.geepawhill.html.basic

import org.geepawhill.html.css.MediaQuery
import org.geepawhill.html.css.Rule
import org.geepawhill.html.css.Selector
import org.geepawhill.html.css.Styles
import org.geepawhill.html.model.HtmlFormatter
import org.geepawhill.html.model.HtmlVisitor

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

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }

    override fun format(formatter: HtmlFormatter): HtmlFormatter {
        formatter.openSelector(rule)
        for (declaration in declarations.entries) formatter.declaration(declaration)
        formatter.closeSelector()
        return formatter
    }
}
