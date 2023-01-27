package org.geepawhill.html.model

interface AttributeOnlyTag : Element {
    val attributes: OrderedMap
    val tag: String

    override fun accept(visitor: HtmlVisitor)
}
