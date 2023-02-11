package org.geepawhill.html.basic

import org.geepawhill.html.css.MediaQuery
import org.geepawhill.html.css.Selector
import org.geepawhill.html.css.Styles
import org.geepawhill.html.model.HtmlFormatter
import org.geepawhill.html.model.HtmlVisitor

class StylesDelegate : Styles {
    override val selectors = mutableListOf<Selector>()
    override val queries = mutableListOf<MediaQuery>()

    override fun selector(rule: String, details: Selector.() -> Unit) {
        val new = SelectorDelegate(this, rule)
        new.details()
        selectors.add(new)
    }

    override operator fun Selector.unaryPlus() {
        selectors.add(this)
    }

    override operator fun MediaQuery.unaryPlus() {
        queries.add(this)
    }

    override fun format(formatter: HtmlFormatter): HtmlFormatter {
        formatter.startStyles()
        for (selector in selectors) selector.format(formatter)
        for (query in queries) query.format(formatter)
        formatter.endStyles()
        return formatter
    }

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }
}
