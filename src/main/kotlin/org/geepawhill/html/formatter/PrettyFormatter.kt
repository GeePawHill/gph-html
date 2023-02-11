package org.geepawhill.html.formatter

import org.geepawhill.html.map.KeyAndValue
import org.geepawhill.html.model.HtmlFormatter

@Suppress("TooManyFunctions")
class PrettyFormatter(
    private val appendable: Appendable = StringBuilder(),
    val indentString: String = PrettyFormatter.DEFAULT_INDENT
) : HtmlFormatter {

    private var depth = 0

    override fun emptyTag(tag: String, attributes: Collection<KeyAndValue>) {
        newline()
        appendable.append("<$tag")
        for (attribute in attributes) appendable.append(" ${attribute.key}=\"${attribute.value}\"")
        appendable.append(">")
    }

    override fun text(text: String) {
        appendable.append(text)
    }

    override fun openContainerTag(tag: String, attributes: Collection<KeyAndValue>) {
        emptyTag(tag, attributes)
        depth += 1
    }

    override fun closeContainerTag(tag: String) {
        depth -= 1
        newline()
        appendable.append("</$tag>")
    }

    override fun openSelector(rule: String) {
        newline()
        appendable.append("$rule {")
        depth += 1
    }

    override fun closeSelector() {
        depth -= 1
        newline()
        appendable.append("}")
    }

    override fun declaration(declaration: KeyAndValue) {
        newline()
        appendable.append("${declaration.key}: ${declaration.value};")
    }

    override fun startStyles() {
        newline()
        appendable.append("<style>")
        depth += 1
    }

    override fun endStyles() {
        depth -= 1
        newline()
        appendable.append("</style>")
    }

    override fun startRule(rule: String) {
        newline()
        appendable.append("$rule {")
        depth += 1
    }

    override fun endRule() {
        depth -= 1
        newline()
        appendable.append("}")
    }

    override fun startQuery(query: String) {
        newline()
        appendable.append("@media $query {")
        depth += 1
    }

    override fun endQuery() {
        depth -= 1
        newline()
        appendable.append("}")
    }

    override fun toString(): String {
        return appendable.toString()
    }

    private fun newline() {
        appendable.append("\n")
        (1..depth).forEach { _ -> appendable.append(indentString) }
    }

    companion object {
        const val DEFAULT_INDENT: String = "  "
    }
}
