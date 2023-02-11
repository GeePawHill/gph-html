package org.geepawhill.html.model

interface Element {
    val flat: String
    fun format(formatter: HtmlFormatter)
    fun accept(visitor: HtmlVisitor)
}
