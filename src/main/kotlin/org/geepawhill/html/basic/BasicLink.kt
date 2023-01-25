package org.geepawhill.html.basic

import org.geepawhill.html.model.InternalTag
import org.geepawhill.html.model.Link
import org.geepawhill.html.basic.BasicTagAttributes.Companion.NO_VALUE

class BasicLink(
    classes: String = NO_VALUE,
    href: String = NO_VALUE,
    target: String = NO_VALUE,
    private val maker: InternalTag = BasicInternalTag("a"),
    details: BasicLink.() -> Unit = {}
) : Link,
    InternalTag by maker {

    override var classes: String by maker.attributes
    override var href: String by maker.attributes
    var target: String by maker.attributes

    init {
        this.classes = classes
        this.href = href
        this.target = target
        details()
    }

    companion object {
    }
}