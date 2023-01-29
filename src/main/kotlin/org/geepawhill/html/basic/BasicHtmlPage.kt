package org.geepawhill.html.basic

import org.geepawhill.html.model.ContainerTag
import org.geepawhill.html.model.HeadTag
import org.geepawhill.html.model.HtmlPage
import org.geepawhill.html.model.InternalTag

class BasicHtmlPage(
    val maker: BasicContainerTag = BasicContainerTag("html"),
) :
    HtmlPage, ContainerTag by maker {

    override fun body(details: InternalTag.() -> Unit) {
        val body = BasicInternalTag("body")
        body.details()
        elements.add(body)
    }

    override fun head(details: HeadTag.() -> Unit) {
        val head = BasicHeadTag()
        head.details()
        elements.add(head)
    }

    companion object {
        fun page(details: BasicHtmlPage.() -> Unit): HtmlPage {
            val page = BasicHtmlPage()
            page.details()
            return page
        }
    }
}
