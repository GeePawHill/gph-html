package org.geepawhill.html.basic

import org.geepawhill.html.css.DisplayDeclaration
import org.geepawhill.html.css.Selector
import org.geepawhill.html.model.AttributeOnlyTag
import org.geepawhill.html.model.HtmlVisitor

class SelectorDelegate(
    val rule: String,
    private val maker: AttributeOnlyTag = AttributeOnlyTagDelegate(rule)
) : Selector, AttributeOnlyTag by maker {

    override val display = DisplayDeclaration(maker.attributes)

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }
}
