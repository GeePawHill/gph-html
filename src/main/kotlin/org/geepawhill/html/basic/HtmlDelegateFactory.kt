package org.geepawhill.html.basic

import org.geepawhill.html.css.Styles
import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.map.OrderedMapDelegate
import org.geepawhill.html.model.AttributeOnlyTag
import org.geepawhill.html.model.ContainerTag
import org.geepawhill.html.model.HeadTag
import org.geepawhill.html.model.HtmlFactory
import org.geepawhill.html.model.InternalTag
import org.geepawhill.html.model.LinkTag

class HtmlDelegateFactory : HtmlFactory {
    override val styles: Styles = StylesDelegate()

    override fun orderedMap(): OrderedMap = OrderedMapDelegate()
    override fun attributeOnlyTag(tag: String): AttributeOnlyTag = AttributeOnlyTagDelegate(tag)
    override fun containerTag(tag: String): ContainerTag = ContainerTagDelegate(tag, this)
    override fun internalTag(tag: String, classes: String): InternalTag = InternalTagDelegate(tag, classes, this)
    override fun headTag(): HeadTag = HeadTagDelegate("head", this)
    override fun linkTag(classes: String, href: String, target: String): LinkTag =
        LinkTagDelegate(classes, href, target, this)
}
