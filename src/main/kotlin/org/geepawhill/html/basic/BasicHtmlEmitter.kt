package org.geepawhill.html.basic

import org.geepawhill.html.model.HtmlEmitter

class BasicHtmlEmitter(private val appendable: Appendable = StringBuilder()) : HtmlEmitter, Appendable by appendable {
    override fun startLine() {
    }

    override fun indent() {
    }

    override fun undent() {
    }

    override fun toString(): String {
        return appendable.toString()
    }

}