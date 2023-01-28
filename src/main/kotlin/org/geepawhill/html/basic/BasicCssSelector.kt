package org.geepawhill.html.basic

import org.geepawhill.html.css.CssDisplay
import org.geepawhill.html.css.CssSelector
import org.geepawhill.html.model.AttributeOnlyTag
import org.geepawhill.html.model.HtmlVisitor

class BasicCssSelector(
    val rule: String,
    private val maker: AttributeOnlyTag = BasicAttributeOnlyTag(rule)
) : CssSelector, AttributeOnlyTag by maker {

    override val display = CssDisplay(maker.attributes)

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }
}
