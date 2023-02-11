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

@Suppress("TooManyFunctions")
class BasicPrettyPrinter(
    val appendable: Appendable = StringBuilder(),
    val indentString: String = DEFAULT_INDENT
) : HtmlVisitor, Appendable by appendable {

    private var depth = 0

    fun print(element: Element): String {
        element.accept(this)
        return appendable.toString()
    }

    override fun visit(text: String) {
        append(text)
    }

    override fun visit(selector: Selector) {
        newline()
        append(selector.rule)
        append(" { ")
        depth += 1
        selector.declarations.entries.forEach { css ->
            newline()
            append("${css.key}: ${css.value};")
        }
        depth -= 1
        newline()
        append("}")
    }

    override fun visit(mediaQuery: MediaQuery) {
        newline()
        appendable.append("@media ${mediaQuery.query}")
        appendable.append(" {")
        depth += 1
        newline()
        append(mediaQuery.rule)
        append(" { ")
        depth += 1
        mediaQuery.declarations.entries.forEach { declaration ->
            newline()
            appendable.append("${declaration.key}: ${declaration.value};")
        }
        depth -= 1
        newline()
        appendable.append("}")
        depth -= 1
        newline()
        appendable.append("}")
    }

    override fun visit(declarations: Declarations) = Unit

    override fun visit(tag: ContainerTag) {
        visit(tag as AttributeOnlyTag)
        depth += 1
        tag.elements.forEach { element -> element.accept(this) }
        depth -= 1
        newline()
        append("</${tag.tag}>")
    }

    override fun visit(tag: AttributeOnlyTag) {
        newline()
        append("<${tag.tag}")
        tag.attributes.entries.forEach { attribute ->
            append(" ${attribute.key}=\"${attribute.value}\"")
        }
        append(">")
    }

    override fun visit(styles: Styles) {
        newline()
        appendable.append("<style>")
        depth += 1
        styles.selectors.forEach { selector ->
            selector.accept(this)
        }
        styles.queries.forEach { query ->
            query.accept(this)
        }
        depth -= 1
        newline()
        appendable.append("</style>")
    }

    override fun visit(page: HtmlPage) {
        appendable.append("<!DOCTYPE html>")
        page.elements.forEach { element ->
            element.accept(this)
        }
    }

    private fun newline() {
        append("\n")
        (1..depth).forEach { _ -> appendable.append(indentString) }
    }

    override fun toString(): String = appendable.toString()

    companion object {
        const val DEFAULT_INDENT = "  "
    }
}
