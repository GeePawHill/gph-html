package org.geepawhill.html.basic

import org.geepawhill.html.model.AttributeOnlyTag
import org.geepawhill.html.model.ContainerTag
import org.geepawhill.html.model.HtmlVisitor

class BasicPrettyPrinter(
    val appendable: Appendable = StringBuilder(),
    val indentString: String = DEFAULT_INDENT
) : HtmlVisitor, Appendable by appendable {

    private var depth = 0

    override fun visit(text: String) {
        append(text)
    }

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
        tag.attributes.forEach { attribute ->
            append(" ${attribute.key}=\"${attribute.value}\"")
        }
        append(">")
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
