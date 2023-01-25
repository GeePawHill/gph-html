package org.geepawhill.html.basic

import org.geepawhill.html.model.HtmlEmitter

class BasicHtmlEmitter(private val appendable: Appendable = StringBuilder()) : HtmlEmitter, Appendable by appendable {
    override fun startLine() = Unit

    override fun indent() = Unit

    override fun undent() = Unit

    override fun toString(): String {
        return appendable.toString()
    }
}
