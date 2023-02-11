package org.geepawhill.html.model

import org.geepawhill.html.formatter.FlatFormatter
import java.net.URLEncoder

class EncodedTextElement(val text: String) : Element {

    override val flat: String
        get() = FlatFormatter().apply { format(this) }.toString()

    override fun format(formatter: HtmlFormatter) {
        formatter.text(URLEncoder.encode(text, "UTF-8"))
    }

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(URLEncoder.encode(text, "UTF-8"))
    }
}
