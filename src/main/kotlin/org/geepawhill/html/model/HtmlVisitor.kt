package org.geepawhill.html.model

import org.geepawhill.html.css.Selector
import org.geepawhill.html.css.Stylesheet

interface HtmlVisitor {
    fun visit(text: String)
    fun visit(selector: Selector)
    fun visit(tag: AttributeOnlyTag)
    fun visit(tag: ContainerTag)
    fun visit(stylesheet: Stylesheet)
    fun visit(page: HtmlPage)
}
