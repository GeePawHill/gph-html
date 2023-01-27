package org.geepawhill.html.model

interface HtmlVisitor {
    fun visit(text: String)
    fun visit(selector: CssSelector)
    fun visit(tag: AttributeOnlyTag)
    fun visit(tag: ContainerTag)
}
