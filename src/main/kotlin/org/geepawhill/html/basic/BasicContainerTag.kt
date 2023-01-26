package org.geepawhill.html.basic

import org.geepawhill.html.model.AttributeTag
import org.geepawhill.html.model.ContainerTag
import org.geepawhill.html.model.Element
import org.geepawhill.html.model.EncodedTextElement
import org.geepawhill.html.model.HtmlEmitter
import org.geepawhill.html.model.TextElement

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

    override fun emit(emitter: HtmlEmitter): String {
        emitter.startLine()
        emitter.append("<$tag")
        emitter.append(attributes.toString())
        emitter.append(">")
        emitter.indent()
        elements.forEach { element ->
            element.emit(emitter)
        }
        emitter.undent()
        emitter.startLine()
        emitter.append("</$tag>")
        return emitter.toString()
    }
}
