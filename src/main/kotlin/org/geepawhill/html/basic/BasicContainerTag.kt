package org.geepawhill.html.basic

import org.geepawhill.html.model.AttributeOnlyTag
import org.geepawhill.html.model.ContainerTag
import org.geepawhill.html.model.Element
import org.geepawhill.html.model.EncodedTextElement
import org.geepawhill.html.model.HtmlVisitor
import org.geepawhill.html.model.TextElement

class BasicContainerTag(tag: String, private val maker: BasicAttributeOnlyTag = BasicAttributeOnlyTag(tag)) :
    ContainerTag, AttributeOnlyTag by maker {

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

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }
}
