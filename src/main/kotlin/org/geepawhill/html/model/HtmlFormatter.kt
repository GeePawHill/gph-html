package org.geepawhill.html.model

import org.geepawhill.html.map.KeyAndValue

interface HtmlFormatter {
    fun format(element: Element): String
    fun emptyTag(tag: String, attributes: Collection<KeyAndValue>)
    fun text(text: String)
}
