package org.geepawhill.html.basic

import org.geepawhill.html.css.CssSelector
import org.geepawhill.html.css.CssStylesheet
import org.geepawhill.html.model.AttributeOnlyTag
import org.geepawhill.html.model.ContainerTag
import org.geepawhill.html.model.Element
import org.geepawhill.html.model.EncodedTextElement
import org.geepawhill.html.model.HtmlVisitor
import org.geepawhill.html.model.TextElement

class BasicContainerTag(
    tag: String,
    override val stylesheet: CssStylesheet = BasicCssStylesheet(),
    private val delegate: BasicAttributeOnlyTag = BasicAttributeOnlyTag(tag)
) :
    ContainerTag, AttributeOnlyTag by delegate {

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

    override fun selector(selector: String, details: CssSelector.() -> Unit) {
        stylesheet.selector(selector, details)
    }

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }
}
