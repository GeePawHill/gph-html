package org.geepawhill.html.model

interface HeadTag : ContainerTag {
    fun title(contents: String)
    fun meta(details: AttributeTag.() -> Unit = {})
    fun link(href: String, rel: String, details: AttributeTag.() -> Unit = {})
    fun script(details: AttributeTag.() -> Unit = {})
}