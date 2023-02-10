package org.geepawhill.html.model

import org.geepawhill.html.css.MediaQuery
import org.geepawhill.html.css.Selector
import org.geepawhill.html.css.Styles

interface HtmlVisitor {
    fun visit(text: String)
    fun visit(mediaQuery: MediaQuery)
    fun visit(selector: Selector)
    fun visit(tag: AttributeOnlyTag)
    fun visit(tag: ContainerTag)
    fun visit(styles: Styles)
    fun visit(page: HtmlPage)
}
