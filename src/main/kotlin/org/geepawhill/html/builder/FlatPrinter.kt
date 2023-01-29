package org.geepawhill.html.builder

import org.geepawhill.html.css.CssSelector
import org.geepawhill.html.model.AttributeOnlyTag
import org.geepawhill.html.model.ContainerTag
import org.geepawhill.html.model.Element
import org.geepawhill.html.model.HtmlVisitor

class FlatPrinter(val appendable: Appendable = StringBuilder()) : HtmlVisitor {

    fun print(element: Element): String {
        element.accept(this)
        return appendable.toString()
    }

    override fun visit(text: String) {
        appendable.append(text)
    }

    override fun visit(selector: CssSelector) {
        appendable.append("${selector.tag}{")
        selector.attributes.ordered.forEach { attribute ->
            appendable.append("${attribute.key}: ${attribute.value};")
        }
        appendable.append("}")
    }

    override fun visit(tag: AttributeOnlyTag) {
        appendable.append("<${tag.tag}")
        tag.attributes.ordered.forEach { attribute ->
            appendable.append(" ${attribute.key}=\"${attribute.value}\"")
        }
        appendable.append(">")
    }

    override fun visit(tag: ContainerTag) {
        visit(tag as AttributeOnlyTag)
        tag.elements.forEach { element -> element.accept(this) }
        appendable.append("</${tag.tag}>")
    }
}
