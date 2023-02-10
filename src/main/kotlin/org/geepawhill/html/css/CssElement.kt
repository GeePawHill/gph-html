package org.geepawhill.html.css

import org.geepawhill.html.model.HtmlVisitor

interface CssElement {
    fun accept(visitor: HtmlVisitor)
}
