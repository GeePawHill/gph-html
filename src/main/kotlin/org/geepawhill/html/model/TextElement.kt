package org.geepawhill.html.model

class TextElement(val text: String) : Element {
    override fun emit(emitter: HtmlEmitter): String {
        emitter.append(text)
        return emitter.toString()
    }

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(text)
    }
}
