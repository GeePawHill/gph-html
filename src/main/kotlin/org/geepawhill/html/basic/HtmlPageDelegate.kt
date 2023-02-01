package org.geepawhill.html.basic

import org.geepawhill.html.css.Stylesheet
import org.geepawhill.html.model.ContainerTag
import org.geepawhill.html.model.HeadTag
import org.geepawhill.html.model.HtmlPage
import org.geepawhill.html.model.HtmlVisitor
import org.geepawhill.html.model.InternalTag

class HtmlPageDelegate(
    override val stylesheet: Stylesheet = StylesheetDelegate(),
    val delegate: ContainerTag = ContainerTagDelegate("html", stylesheet),
) :
    HtmlPage, ContainerTag by delegate {

    override fun body(details: InternalTag.() -> Unit) {
        val body = InternalTagDelegate("body", stylesheet = stylesheet)
        body.details()
        elements.add(body)
    }

    override fun head(details: HeadTag.() -> Unit) {
        val head = HeadTagDelegate(stylesheet)
        head.details()
        elements.add(head)
    }

    override fun accept(visitor: HtmlVisitor) {
        visitor.visit(this)
    }

    companion object {
        fun page(details: HtmlPageDelegate.() -> Unit): HtmlPage {
            val page = HtmlPageDelegate()
            page.details()
            return page
        }
    }
}
