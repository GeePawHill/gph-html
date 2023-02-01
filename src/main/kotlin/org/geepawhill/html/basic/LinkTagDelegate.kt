package org.geepawhill.html.basic

import org.geepawhill.html.css.Stylesheet
import org.geepawhill.html.map.OrderedMap.Companion.NO_VALUE
import org.geepawhill.html.model.InternalTag
import org.geepawhill.html.model.LinkTag

class LinkTagDelegate(
    classes: String = NO_VALUE,
    stylesheet: Stylesheet = StylesheetDelegate(),
    href: String = NO_VALUE,
    target: String = NO_VALUE,
    private val delegate: InternalTag = InternalTagDelegate("a", classes, stylesheet),
    details: LinkTagDelegate.() -> Unit = {}
) : LinkTag,
    InternalTag by delegate {

    override var classes: String by attributes.field("class")
    override var href: String by attributes.field("href")
    var target: String by attributes.field("target")

    init {
        this.classes = classes
        this.href = href
        this.target = target
        details()
    }
}
