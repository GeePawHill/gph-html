package org.geepawhill.html.model

import org.geepawhill.html.basic.BasicHtmlEmitter

interface Element {
    fun accept(visitor: HtmlVisitor)
    fun emit(emitter: HtmlEmitter = BasicHtmlEmitter()): String
}
