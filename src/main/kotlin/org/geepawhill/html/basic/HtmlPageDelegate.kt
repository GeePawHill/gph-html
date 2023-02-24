package org.geepawhill.html.basic

import org.geepawhill.html.model.ContainerTag
import org.geepawhill.html.model.HeadTag
import org.geepawhill.html.model.HtmlFactory
import org.geepawhill.html.model.HtmlPage
import org.geepawhill.html.model.InternalTag

class HtmlPageDelegate(
    factory: HtmlFactory,
) :
    HtmlPage, ContainerTag by factory.containerTag("page") {

    override fun body(details: InternalTag.() -> Unit) {
        val body = factory.internalTag("body")
        body.details()
        +body
    }

    override fun head(details: HeadTag.() -> Unit) {
        val head = factory.headTag()
        head.details()
        +head
    }

    companion object {
        fun page(details: HtmlPageDelegate.() -> Unit): HtmlPage {
            val page = HtmlPageDelegate(HtmlDelegateFactory())
            page.details()
            return page
        }
    }
}
