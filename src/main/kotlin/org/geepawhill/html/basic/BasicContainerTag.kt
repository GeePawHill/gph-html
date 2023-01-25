package org.geepawhill.html.basic

import org.geepawhill.html.model.AttributeTag
import org.geepawhill.html.model.ContainerTag
import org.geepawhill.html.model.Element
import org.geepawhill.html.model.TextElement

class BasicContainerTag(tag: String, val maker: BasicAttributeTag = BasicAttributeTag(tag)) : ContainerTag,
    AttributeTag by maker {

    override val elements = mutableListOf<Element>()

    override operator fun Element.unaryPlus() {
        elements.add(this)
    }

    override operator fun String.unaryPlus() {
        elements.add(TextElement(this))
    }

    override fun emit(builder: StringBuilder): String {
        builder.append("<$tag")
        builder.append(attributes.toString())
        builder.append(">")
        elements.forEach { element ->
            element.emit(builder)
        }
        builder.append("</$tag>")
        return builder.toString()
    }
}