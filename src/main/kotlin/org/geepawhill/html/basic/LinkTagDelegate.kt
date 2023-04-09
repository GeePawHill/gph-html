package org.geepawhill.html.basic

import org.geepawhill.html.model.HtmlFactory
import org.geepawhill.html.model.InternalTag
import org.geepawhill.html.model.LinkTag

class LinkTagDelegate(
    classes: String,
    href: String,
    target: String,
    factory: HtmlFactory
) : LinkTag,
    InternalTag by factory.internalTag("a", classes) {

    override var href: String by attributes.field("href")
    override var target: String by attributes.field("target")

    init {
        this.classes = classes
        this.href = href
        this.target = target
    }
}
