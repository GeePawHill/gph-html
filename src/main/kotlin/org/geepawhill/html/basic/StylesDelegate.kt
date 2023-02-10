package org.geepawhill.html.basic

import org.geepawhill.html.css.CssElement
import org.geepawhill.html.css.Selector
import org.geepawhill.html.css.Styles
import org.geepawhill.html.model.HtmlVisitor

class StylesDelegate : Styles {
    override val selectors = mutableListOf<CssElement>()

    override fun selector(selector: String, details: Selector.() -> Unit) {
        val new = SelectorDelegate(this, selector)
        new.details()
        selectors.add(new)
    }

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }
}
