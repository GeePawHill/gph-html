package org.geepawhill.html.model

class TextElement(val text: String) : Element {
    override fun format(formatter: HtmlFormatter) {
        formatter.text(text)
    }

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(text)
    }
}
