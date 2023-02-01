package org.geepawhill.html.basic

import org.geepawhill.html.css.Selector
import org.geepawhill.html.css.Stylesheet
import org.geepawhill.html.model.AttributeOnlyTag
import org.geepawhill.html.model.ContainerTag
import org.geepawhill.html.model.Element
import org.geepawhill.html.model.EncodedTextElement
import org.geepawhill.html.model.HtmlVisitor
import org.geepawhill.html.model.TextElement

class ContainerTagDelegate(
    tag: String,
    override val stylesheet: Stylesheet = StylesheetDelegate(),
    private val delegate: AttributeOnlyTagDelegate = AttributeOnlyTagDelegate(tag)
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

    override fun selector(selector: String, details: Selector.() -> Unit) {
        stylesheet.selector(selector, details)
    }

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }
}