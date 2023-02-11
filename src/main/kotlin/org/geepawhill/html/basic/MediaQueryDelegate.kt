package org.geepawhill.html.basic

import org.geepawhill.html.css.MediaQuery
import org.geepawhill.html.css.Rule
import org.geepawhill.html.css.Styles
import org.geepawhill.html.formatter.FlatFormatter
import org.geepawhill.html.model.HtmlFormatter
import org.geepawhill.html.model.HtmlVisitor

class MediaQueryDelegate(
    styles: Styles,
    override val query: String,
    rule: String,
    val delegate: Rule = RuleDelegate(styles, rule)

) : MediaQuery,
    Rule by delegate {

    override val flat: String
        get() = FlatFormatter().apply { format(this) }.toString()

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }

    override fun format(formatter: HtmlFormatter) {
        formatter.startQuery(query)
        delegate.format(formatter)
        formatter.endQuery()
    }
}
