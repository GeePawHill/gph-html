package org.geepawhill.html.basic

import org.geepawhill.html.model.AttributeTag
import org.geepawhill.html.model.ContainerTag
import org.geepawhill.html.model.HeadTag

class BasicHeadTag(maker: BasicContainerTag = BasicContainerTag("head")) : HeadTag, ContainerTag by maker {
    override fun title(contents: String) {
        val tag = BasicInternalTag("title")
        tag.attributes["contents"] = contents
        elements.add(tag)
    }

    override fun meta(details: AttributeTag.() -> Unit) {
        val tag = BasicAttributeTag("meta")
        tag.details()
        elements.add(tag)
    }

    override fun link(href: String, rel: String, details: AttributeTag.() -> Unit) {
        val tag = BasicAttributeTag("link")
        tag.attributes["href"] = href
        tag.attributes["rel"] = rel
        tag.details()
        elements.add(tag)
    }

    override fun script(details: AttributeTag.() -> Unit) {
        val tag = BasicInternalTag("script")
        tag.details()
        elements.add(tag)
    }
}