package org.geepawhill.html.basic

import org.geepawhill.html.model.HtmlEmitter

class PrettyHtmlEmitter(
    private val appendable: Appendable = StringBuilder()
) : HtmlEmitter, Appendable by appendable {

    private var depth = 0

    override fun startLine() {
        appendable.append("\n")
        (1..depth).forEach { _ ->
            appendable.append(" ")
        }
    }

    override fun indent() {
        depth += 1
    }

    override fun undent() {
        depth = minOf(0, depth - 1)
    }

    override fun toString(): String {
        return appendable.toString()
    }
}
