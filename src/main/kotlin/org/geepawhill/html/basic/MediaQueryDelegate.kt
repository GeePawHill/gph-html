package org.geepawhill.html.basic

import org.geepawhill.html.css.MediaQuery
import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.map.OrderedMapDelegate
import org.geepawhill.html.model.HtmlVisitor

class MediaQueryDelegate(
    override val rule: String,
    override val selector: String,
) : MediaQuery {
    
    override val declarations: OrderedMap = OrderedMapDelegate()

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }
}
