package org.geepawhill.html.model

import org.geepawhill.html.formatter.FlatFormatter
import org.geepawhill.html.formatter.PrettyFormatter

interface Element {
    fun format(formatter: HtmlFormatter): HtmlFormatter
    fun accept(visitor: HtmlVisitor)

    companion object {
        val Element.flat: String get() = format(FlatFormatter()).toString()
        val Element.pretty: String get() = format(PrettyFormatter()).toString()
    }
}
