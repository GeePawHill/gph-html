package org.geepawhill.html.model

import org.geepawhill.html.css.Styles
import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.map.OrderedMap.Companion.NO_VALUE

interface HtmlFactory {
    val styles: Styles

    fun orderedMap(): OrderedMap
    fun containerTag(tag: String): ContainerTag
    fun internalTag(tag: String, classes: String = NO_VALUE): InternalTag
    fun attributeOnlyTag(tag: String): AttributeOnlyTag
    fun headTag(): HeadTag
    fun linkTag(classes: String = NO_VALUE, href: String = NO_VALUE, target: String = NO_VALUE): LinkTag
}
