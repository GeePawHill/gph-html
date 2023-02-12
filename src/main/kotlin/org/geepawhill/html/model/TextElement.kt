package org.geepawhill.html.model

class TextElement(val text: String) : Element {

    override fun format(formatter: HtmlFormatter): HtmlFormatter {
        formatter.text(text)
        return formatter
    }
}
