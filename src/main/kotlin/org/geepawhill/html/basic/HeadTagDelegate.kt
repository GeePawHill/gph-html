package org.geepawhill.html.basic

import org.geepawhill.html.css.Styles
import org.geepawhill.html.model.AttributeOnlyTag
import org.geepawhill.html.model.ContainerTag
import org.geepawhill.html.model.HeadTag

class HeadTagDelegate(
    styles: Styles,
    private val delegate: ContainerTagDelegate = ContainerTagDelegate("head", styles)
) : HeadTag, ContainerTag by delegate {

    override fun title(contents: String) {
        val tag = InternalTagDelegate(styles, "title")
        tag.attributes["contents"] = contents
        elements.add(tag)
    }

    override fun meta(details: AttributeOnlyTag.() -> Unit) {
        val tag = AttributeOnlyTagDelegate("meta")
        tag.details()
        elements.add(tag)
    }

    override fun link(href: String, rel: String, details: AttributeOnlyTag.() -> Unit) {
        val tag = AttributeOnlyTagDelegate("link")
        tag.attributes["href"] = href
        tag.attributes["rel"] = rel
        tag.details()
        elements.add(tag)
    }

    override fun script(details: AttributeOnlyTag.() -> Unit) {
        val tag = InternalTagDelegate(styles, "script")
        tag.details()
        elements.add(tag)
    }

    override fun stylesheet(details: Styles.() -> Unit) {
        delegate.styles.details()
        elements.add(delegate.styles)
    }
}
