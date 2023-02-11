package org.geepawhill.html.model

import org.geepawhill.html.formatter.FlatFormatter

class TextElement(val text: String) : Element {

    override val flat: String
        get() = FlatFormatter().apply { format(this) }.toString()

    override fun format(formatter: HtmlFormatter) {
        formatter.text(text)
    }

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(text)
    }
}
