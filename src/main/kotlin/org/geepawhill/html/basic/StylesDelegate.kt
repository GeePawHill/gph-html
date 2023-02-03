package org.geepawhill.html.basic

import org.geepawhill.html.css.Selector
import org.geepawhill.html.css.Styles
import org.geepawhill.html.model.HtmlVisitor

class StylesDelegate : Styles {
    override val selectors = mutableListOf<Selector>()

    override fun selector(selector: String, details: Selector.() -> Unit) {
        val new = SelectorDelegate(selector)
        new.details()
        selectors.add(new)
    }

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }
}
