package org.geepawhill.html.basic

import org.geepawhill.html.map.OrderedMap.Companion.NO_VALUE
import org.geepawhill.html.model.InternalTag
import org.geepawhill.html.model.Link

class BasicLink(
    classes: String = NO_VALUE,
    href: String = NO_VALUE,
    target: String = NO_VALUE,
    private val delegate: InternalTag = InternalTagDelegate("a"),
    details: BasicLink.() -> Unit = {}
) : Link,
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
