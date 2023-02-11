package org.geepawhill.html.formatter

import org.geepawhill.html.map.KeyAndValue
import org.geepawhill.html.model.Element
import org.geepawhill.html.model.HtmlFormatter

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

    override fun toString(): String = appendable.toString()
}
