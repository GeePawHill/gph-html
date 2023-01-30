package org.geepawhill.html.basic

import org.geepawhill.html.css.CssSelector
import org.geepawhill.html.css.CssStylesheet
import org.geepawhill.html.model.HtmlVisitor

class BasicCssStylesheet : CssStylesheet {
    override val selectors = mutableListOf<CssSelector>()

    override fun selector(selector: String, details: CssSelector.() -> Unit) {
        val new = BasicCssSelector(selector)
        new.details()
        selectors.add(new)
    }

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }
}
