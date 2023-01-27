package org.geepawhill.html.basic

import org.geepawhill.html.model.AttributeOnlyTag
import org.geepawhill.html.model.CssSelector
import org.geepawhill.html.model.HtmlVisitor
import org.junit.jupiter.api.Test

class BasicSelector(
    val rule: String,
    private val maker: AttributeOnlyTag = BasicAttributeOnlyTag(rule)
) : CssSelector, AttributeOnlyTag by maker {
    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }
}

class BasicSelectorTest {
    val printer = BasicPrettyPrinter()
    val selector = BasicSelector("*")

    @Test
    fun `empty selector works`() {
        selector.accept(printer)
        println(printer.toString())
    }

    @Test
    fun `direct set works`() {
        selector.apply {
            attributes["width"] = "10px"
        }
        selector.accept(printer)
        println(printer.toString())
    }
}
