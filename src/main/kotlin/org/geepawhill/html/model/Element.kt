package org.geepawhill.html.model

interface Element {
    fun accept(visitor: HtmlVisitor)
}
