package org.geepawhill.html.model

import org.geepawhill.html.basic.BasicHtmlEmitter

interface Element {
    fun emit(builder: StringBuilder = StringBuilder(), emitter: HtmlEmitter = BasicHtmlEmitter()): String
}
