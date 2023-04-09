package org.geepawhill.html.basic

import org.geepawhill.html.css.Selector
import org.geepawhill.html.css.Styles
import org.geepawhill.html.model.AttributeOnlyTag
import org.geepawhill.html.model.ContainerTag
import org.geepawhill.html.model.Element
import org.geepawhill.html.model.EncodedTextElement
import org.geepawhill.html.model.HtmlFactory
import org.geepawhill.html.model.HtmlFormatter
import org.geepawhill.html.model.TextElement

class ContainerTagDelegate(
    tag: String,
    override val factory: HtmlFactory,
) :
    ContainerTag, AttributeOnlyTag by factory.attributeOnlyTag(tag) {
    override val styles: Styles = factory.styles

    override var classes by attributes.field("class")
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

    override fun selectorAs(selector: String) {
        classes = selector
    }

    override fun selectorAs(selector: String, details: Selector.() -> Unit) {
        classes = selector
        selector(".$selector", details)
    }

    override fun format(formatter: HtmlFormatter): HtmlFormatter {
        formatter.openContainerTag(tag, attributes.entries)
        for (element in elements) element.format(formatter)
        formatter.closeContainerTag(tag)
        return formatter
    }
}
