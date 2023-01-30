package org.geepawhill.html.model

import org.geepawhill.html.css.CssSelector
import org.geepawhill.html.css.CssStylesheet

interface HtmlVisitor {
    fun visit(text: String)
    fun visit(selector: CssSelector)
    fun visit(tag: AttributeOnlyTag)
    fun visit(tag: ContainerTag)
    fun visit(stylesheet: CssStylesheet)
    fun visit(htmlPage: HtmlPage)
}
