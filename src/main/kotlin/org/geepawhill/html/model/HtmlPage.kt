package org.geepawhill.html.model

interface HtmlPage : ContainerTag {
    fun body(details: InternalTag.() -> Unit = {})
    fun head(details: HeadTag.() -> Unit = {})
}
