package org.geepawhill.html.model

interface HtmlEmitter : Appendable {
    fun startLine()
    fun indent()
    fun undent()
}
