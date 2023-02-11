package org.geepawhill.html.builder

import org.geepawhill.html.css.Declarations
import org.geepawhill.html.css.MediaQuery
import org.geepawhill.html.css.Selector
import org.geepawhill.html.css.Styles
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
        appendable.append("${selector.rule}{")
        selector.declarations.entries.forEach { declaration ->
            appendable.append("${declaration.key}: ${declaration.value};")
        }
        appendable.append("}")
    }

    override fun visit(mediaQuery: MediaQuery) {
        appendable.append("@media ${mediaQuery.query}")
        appendable.append(" {")
        mediaQuery.declarations.entries.forEach { declaration ->
            appendable.append("${declaration.key}: ${declaration.value};")
        }
        appendable.append("}")
    }

    override fun visit(declarations: Declarations) {
        appendable.append("${declarations.rule}{")
        declarations.declarations.entries.forEach { declaration ->
            appendable.append("${declaration.key}: ${declaration.value};")
        }
        appendable.append("}")
    }

    override fun visit(tag: AttributeOnlyTag) {
        appendable.append("<${tag.tag}")
        tag.attributes.entries.forEach { attribute ->
            appendable.append(" ${attribute.key}=\"${attribute.value}\"")
        }
        appendable.append(">")
    }

    override fun visit(tag: ContainerTag) {
        visit(tag as AttributeOnlyTag)
        tag.elements.forEach { element -> element.accept(this) }
        appendable.append("</${tag.tag}>")
    }

    override fun visit(styles: Styles) {
        appendable.append("<style>")
        styles.selectors.forEach { selector ->
            selector.accept(this)
        }
        styles.queries.forEach { selector ->
            selector.accept(this)
        }
        appendable.append("</style>")
    }

    override fun visit(page: HtmlPage) {
        appendable.append("<!DOCTYPE html>")
        page.elements.forEach { element ->
            element.accept(this)
        }
    }
}
