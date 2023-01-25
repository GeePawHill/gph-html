package org.geepawhill.html.basic

import org.geepawhill.html.model.*

class BasicContainerTag(tag: String, private val maker: BasicAttributeTag = BasicAttributeTag(tag)) :
    ContainerTag, AttributeTag by maker {

    override val elements = mutableListOf<Element>()

    override operator fun Element.unaryPlus() {
        elements.add(this)
    }

    override operator fun String.unaryPlus() {
        elements.add(TextElement(this))
    }

    override fun String.unaryMinus() {
        elements.add(EncodedTextElement(this))
    }

    override fun emit(builder: StringBuilder, emitter: HtmlEmitter): String {
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
