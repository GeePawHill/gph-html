package org.geepawhill.html.model

import org.geepawhill.html.basic.BasicHtmlEmitter

interface Element {
    fun emit(emitter: HtmlEmitter = BasicHtmlEmitter()): String
}
