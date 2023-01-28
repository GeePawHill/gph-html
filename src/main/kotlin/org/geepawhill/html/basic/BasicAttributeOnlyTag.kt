package org.geepawhill.html.basic

import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.model.AttributeOnlyTag
import org.geepawhill.html.model.HtmlEmitter
import org.geepawhill.html.model.HtmlVisitor

class BasicAttributeOnlyTag(override val tag: String, override val attributes: OrderedMap = BasicOrderedMap()) :
    AttributeOnlyTag {

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }

    override fun emit(emitter: HtmlEmitter): String {
        emitter.startLine()
        emitter.append("<$tag")
        emitter.append(attributes.toString())
        emitter.append(">")
        return emitter.toString()
    }
}
