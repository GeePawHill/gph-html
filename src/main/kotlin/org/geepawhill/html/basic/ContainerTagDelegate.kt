package org.geepawhill.html.basic

import org.geepawhill.html.css.Selector
import org.geepawhill.html.css.Styles
import org.geepawhill.html.model.AttributeOnlyTag
import org.geepawhill.html.model.ContainerTag
import org.geepawhill.html.model.Element
import org.geepawhill.html.model.EncodedTextElement
import org.geepawhill.html.model.HtmlFormatter
import org.geepawhill.html.model.TextElement

class ContainerTagDelegate(
    tag: String,
    override val styles: Styles,
    private val delegate: AttributeOnlyTag = AttributeOnlyTagDelegate(tag)
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
        styles.selector(selector, details)
    }

    override fun format(formatter: HtmlFormatter): HtmlFormatter {
        formatter.openContainerTag(tag, attributes.entries)
        for (element in elements) element.format(formatter)
        formatter.closeContainerTag(tag)
        return formatter
    }
}
