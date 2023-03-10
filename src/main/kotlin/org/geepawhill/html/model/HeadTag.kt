package org.geepawhill.html.model

import org.geepawhill.html.css.Styles

interface HeadTag : ContainerTag {
    fun title(contents: String)
    fun meta(details: AttributeOnlyTag.() -> Unit = {})
    fun link(href: String, rel: String, details: AttributeOnlyTag.() -> Unit = {})
    fun script(details: AttributeOnlyTag.() -> Unit = {})
    fun stylesheet(details: Styles.() -> Unit)
}
