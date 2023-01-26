package org.geepawhill.html.model

import java.net.URLEncoder

class EncodedTextElement(val text: String) : Element {
    override fun emit(emitter: HtmlEmitter): String {
        emitter.append(URLEncoder.encode(text, "UTF-8"))
        return emitter.toString()
    }
}
