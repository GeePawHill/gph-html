package org.geepawhill.html.basic

import org.geepawhill.html.css.Declarations
import org.geepawhill.html.css.MediaQuery
import org.geepawhill.html.css.Styles
import org.geepawhill.html.model.HtmlVisitor

class MediaQueryDelegate(
    styles: Styles,
    override val query: String,
    rule: String,
    val delegate: Declarations = DeclarationsDelegate(styles, rule)

) : MediaQuery,
    Declarations by delegate {

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }
}
