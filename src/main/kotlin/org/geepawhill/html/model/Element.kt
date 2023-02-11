package org.geepawhill.html.model

import org.geepawhill.html.formatter.FlatFormatter

interface Element {
    val flat: String get() = FlatFormatter().format(this)
    fun format(formatter: HtmlFormatter)
    fun accept(visitor: HtmlVisitor)
}
