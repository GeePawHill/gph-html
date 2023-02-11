package org.geepawhill.html.basic

import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.map.OrderedMapDelegate
import org.geepawhill.html.model.AttributeOnlyTag
import org.geepawhill.html.model.HtmlFormatter
import org.geepawhill.html.model.HtmlVisitor

class AttributeOnlyTagDelegate(
    override val tag: String,
    override val attributes: OrderedMap = OrderedMapDelegate()
) : AttributeOnlyTag {

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }

    override fun format(formatter: HtmlFormatter) {
        formatter.emptyTag(tag, attributes.entries)
    }
}
