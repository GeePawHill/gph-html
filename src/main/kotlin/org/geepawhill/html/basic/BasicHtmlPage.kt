package org.geepawhill.html.basic

import org.geepawhill.html.css.CssStylesheet
import org.geepawhill.html.model.ContainerTag
import org.geepawhill.html.model.HeadTag
import org.geepawhill.html.model.HtmlPage
import org.geepawhill.html.model.HtmlVisitor
import org.geepawhill.html.model.InternalTag

class BasicHtmlPage(
    override val stylesheet: CssStylesheet = BasicCssStylesheet(),
    val delegate: ContainerTag = BasicContainerTag("html", stylesheet),
) :
    HtmlPage, ContainerTag by delegate {

    override fun body(details: InternalTag.() -> Unit) {
        val body = InternalTagDelegate("body", stylesheet = stylesheet)
        body.details()
        elements.add(body)
    }

    override fun head(details: HeadTag.() -> Unit) {
        val head = BasicHeadTag(stylesheet)
        head.details()
        elements.add(head)
    }

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }

    companion object {
        fun page(details: BasicHtmlPage.() -> Unit): HtmlPage {
            val page = BasicHtmlPage()
            page.details()
            return page
        }
    }
}
