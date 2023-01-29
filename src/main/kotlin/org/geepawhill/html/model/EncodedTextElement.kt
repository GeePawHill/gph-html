package org.geepawhill.html.model

import java.net.URLEncoder

class EncodedTextElement(val text: String) : Element {
    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(URLEncoder.encode(text, "UTF-8"))
    }
}
