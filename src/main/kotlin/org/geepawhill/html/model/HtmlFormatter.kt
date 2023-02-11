package org.geepawhill.html.model

import org.geepawhill.html.map.KeyAndValue

interface HtmlFormatter {
    fun emptyTag(tag: String, attributes: Collection<KeyAndValue>)
}
