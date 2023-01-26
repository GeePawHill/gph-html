package org.geepawhill.html.basic

import org.geepawhill.html.model.AttributeTag
import org.geepawhill.html.model.HtmlEmitter
import org.geepawhill.html.model.TagAttributes

class BasicAttributeTag(override val tag: String, override val attributes: TagAttributes = BasicTagAttributes()) :
    AttributeTag {
    override fun emit(emitter: HtmlEmitter): String {
        emitter.startLine()
        emitter.append("<$tag")
        emitter.append(attributes.toString())
        emitter.append(">")
        return emitter.toString()
    }
}
