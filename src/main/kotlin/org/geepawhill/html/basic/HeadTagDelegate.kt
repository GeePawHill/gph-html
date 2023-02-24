package org.geepawhill.html.basic

import org.geepawhill.html.css.Styles
import org.geepawhill.html.model.AttributeOnlyTag
import org.geepawhill.html.model.ContainerTag
import org.geepawhill.html.model.HeadTag
import org.geepawhill.html.model.HtmlFactory

class HeadTagDelegate(
    tag: String,
    factory: HtmlFactory,
) : HeadTag, ContainerTag by factory.containerTag(tag) {

    override fun title(contents: String) {
        val tag = factory.internalTag("title")
        tag.attributes["contents"] = contents
        +tag
    }

    override fun meta(details: AttributeOnlyTag.() -> Unit) {
        val tag = factory.attributeOnlyTag("meta")
        tag.details()
        +tag
    }

    override fun link(href: String, rel: String, details: AttributeOnlyTag.() -> Unit) {
        val tag = factory.attributeOnlyTag("link")
        tag.attributes["href"] = href
        tag.attributes["rel"] = rel
        tag.details()
        +tag
    }

    override fun script(details: AttributeOnlyTag.() -> Unit) {
        val tag = factory.internalTag("script")
        tag.details()
        +tag
    }

    override fun stylesheet(details: Styles.() -> Unit) {
        styles.details()
        +styles
    }
}
