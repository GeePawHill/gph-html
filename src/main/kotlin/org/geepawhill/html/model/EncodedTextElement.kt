package org.geepawhill.html.model

import java.net.URLEncoder

class EncodedTextElement(val text: String) : Element {

    override fun format(formatter: HtmlFormatter): HtmlFormatter {
        return formatter.apply { text(URLEncoder.encode(text, "UTF-8")) }
    }
}
