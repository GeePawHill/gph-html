package org.geepawhill.html.basic

import org.geepawhill.html.model.AttributeTag
import org.geepawhill.html.model.TagAttributes

class BasicAttributeTag(override val tag: String, override val attributes: TagAttributes = BasicTagAttributes()) :
    AttributeTag {
    override fun emit(builder: StringBuilder): String {
        builder.append("<$tag")
        builder.append(attributes.toString())
        builder.append(">")
        return builder.toString()
    }
}
