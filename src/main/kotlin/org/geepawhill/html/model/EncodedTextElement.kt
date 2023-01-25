package org.geepawhill.html.model

import java.net.URLEncoder

class EncodedTextElement(val text: String) : Element {
    override fun emit(builder: StringBuilder): String {
        builder.append(URLEncoder.encode(text, "UTF-8"))
        return builder.toString()
    }
}
