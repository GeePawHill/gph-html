package org.geepawhill.html.basic

import org.geepawhill.html.map.MappedField
import org.geepawhill.html.map.OrderedMap.Companion.NO_VALUE
import org.geepawhill.html.model.InternalTag
import org.geepawhill.html.model.Link

class BasicLink(
    classes: String = NO_VALUE,
    href: String = NO_VALUE,
    target: String = NO_VALUE,
    private val maker: InternalTag = BasicInternalTag("a"),
    details: BasicLink.() -> Unit = {}
) : Link,
    InternalTag by maker {

    override var classes: String by MappedField("class", attributes)
    override var href: String by MappedField("href", attributes)
    var target: String by MappedField("target", attributes)

    init {
        this.classes = classes
        this.href = href
        this.target = target
        details()
    }
}
