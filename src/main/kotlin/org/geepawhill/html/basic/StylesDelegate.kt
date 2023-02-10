package org.geepawhill.html.basic

import org.geepawhill.html.css.MediaQuery
import org.geepawhill.html.css.Selector
import org.geepawhill.html.css.Styles
import org.geepawhill.html.model.HtmlVisitor

class StylesDelegate : Styles {
    override val selectors = mutableListOf<Selector>()
    override val queries = mutableListOf<MediaQuery>()

    override fun selector(rule: String, details: Selector.() -> Unit) {
        val new = SelectorDelegate(this, rule)
        new.details()
        selectors.add(new)
    }

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }
}
