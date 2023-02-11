package org.geepawhill.html.formatter

import org.geepawhill.html.map.KeyAndValue
import org.geepawhill.html.model.Element
import org.geepawhill.html.model.HtmlFormatter

@Suppress("TooManyFunctions")
class FlatFormatter(private val appendable: Appendable = StringBuilder()) : HtmlFormatter {
    override fun format(element: Element): String {
        element.format(this)
        return toString()
    }

    override fun emptyTag(tag: String, attributes: Collection<KeyAndValue>) {
        appendable.append("<$tag")
        for (attribute in attributes) appendable.append(" ${attribute.key}=\"${attribute.value}\"")
        appendable.append(">")
    }

    override fun text(text: String) {
        appendable.append(text)
    }

    override fun openContainerTag(tag: String, attributes: Collection<KeyAndValue>) {
        emptyTag(tag, attributes)
    }

    override fun closeContainerTag(tag: String) {
        appendable.append("</$tag>")
    }

    override fun openSelector(rule: String) {
        appendable.append(" $rule {")
    }

    override fun closeSelector() {
        appendable.append(" }")
    }

    override fun declaration(declaration: KeyAndValue) {
        appendable.append(" ${declaration.key}: ${declaration.value};")
    }

    override fun startStyles() {
        appendable.append("<style>")
    }

    override fun endStyles() {
        appendable.append("</style>")
    }

    override fun startRule(rule: String) {
        appendable.append("$rule {")
    }

    override fun endRule() {
        appendable.append(" }")
    }

    override fun startQuery(query: String) {
        appendable.append("@media $query { ")
    }

    override fun endQuery() {
        appendable.append(" }")
    }

    override fun toString(): String = appendable.toString()
}
