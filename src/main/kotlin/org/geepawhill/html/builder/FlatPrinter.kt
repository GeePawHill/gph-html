package org.geepawhill.html.builder

import org.geepawhill.html.css.Selector
import org.geepawhill.html.css.Stylesheet
import org.geepawhill.html.model.AttributeOnlyTag
import org.geepawhill.html.model.ContainerTag
import org.geepawhill.html.model.Element
import org.geepawhill.html.model.HtmlPage
import org.geepawhill.html.model.HtmlVisitor

class FlatPrinter(val appendable: Appendable = StringBuilder()) : HtmlVisitor {

    fun print(element: Element): String {
        element.accept(this)
        return appendable.toString()
    }

    override fun visit(text: String) {
        appendable.append(text)
    }

    override fun visit(selector: Selector) {
        appendable.append("${selector.tag}{")
        selector.attributes.forEach { attribute ->
            appendable.append("${attribute.key}: ${attribute.value};")
        }
        appendable.append("}")
    }

    override fun visit(tag: AttributeOnlyTag) {
        appendable.append("<${tag.tag}")
        tag.attributes.forEach { attribute ->
            appendable.append(" ${attribute.key}=\"${attribute.value}\"")
        }
        appendable.append(">")
    }

    override fun visit(tag: ContainerTag) {
        visit(tag as AttributeOnlyTag)
        tag.elements.forEach { element -> element.accept(this) }
        appendable.append("</${tag.tag}>")
    }

    override fun visit(stylesheet: Stylesheet) {
        appendable.append("<stylesheet>")
        stylesheet.selectors.forEach { selector ->
            selector.accept(this)
        }
        appendable.append("</stylesheet>")
    }

    override fun visit(page: HtmlPage) {
        appendable.append("<!DOCTYPE html>")
        page.elements.forEach { element ->
            element.accept(this)
        }
    }
}
