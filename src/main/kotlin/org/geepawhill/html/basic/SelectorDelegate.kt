package org.geepawhill.html.basic

import org.geepawhill.html.css.Declarations
import org.geepawhill.html.css.MediaQuery
import org.geepawhill.html.css.Selector
import org.geepawhill.html.css.Styles
import org.geepawhill.html.model.HtmlVisitor

class SelectorDelegate(
    styles: Styles,
    rule: String,
    private val delegate: DeclarationsDelegate = DeclarationsDelegate(styles, rule)
) : Selector,
    Declarations by delegate {
    override fun media(query: String, details: MediaQuery.() -> Unit) = Unit

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }
}
