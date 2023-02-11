package org.geepawhill.html.basic

import org.geepawhill.html.css.MediaQuery
import org.geepawhill.html.css.Selector
import org.geepawhill.html.css.Styles
import org.geepawhill.html.formatter.FlatFormatter
import org.geepawhill.html.model.HtmlFormatter
import org.geepawhill.html.model.HtmlVisitor

class StylesDelegate : Styles {
    override val flat: String
        get() = FlatFormatter().apply { format(this) }.toString()
    override val selectors = mutableListOf<Selector>()
    override val queries = mutableListOf<MediaQuery>()

    override fun selector(rule: String, details: Selector.() -> Unit) {
        val new = SelectorDelegate(this, rule)
        new.details()
        selectors.add(new)
    }

    override fun format(formatter: HtmlFormatter) {
        TODO("Not yet implemented")
    }

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }
}
