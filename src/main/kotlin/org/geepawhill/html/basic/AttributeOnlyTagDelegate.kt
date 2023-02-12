package org.geepawhill.html.basic

import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.map.OrderedMapDelegate
import org.geepawhill.html.model.AttributeOnlyTag
import org.geepawhill.html.model.HtmlFormatter

class AttributeOnlyTagDelegate(
    override val tag: String,
    override val attributes: OrderedMap = OrderedMapDelegate()
) : AttributeOnlyTag {

    override fun format(formatter: HtmlFormatter): HtmlFormatter {
        formatter.emptyTag(tag, attributes.entries)
        return formatter
    }
}
