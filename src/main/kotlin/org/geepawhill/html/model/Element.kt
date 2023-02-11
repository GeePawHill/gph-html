package org.geepawhill.html.model

import org.geepawhill.html.formatter.FlatFormatter

interface Element {
    fun format(formatter: HtmlFormatter)
    fun accept(visitor: HtmlVisitor)

    companion object {
        val Element.flat: String get() = FlatFormatter().format(this)
    }
}
