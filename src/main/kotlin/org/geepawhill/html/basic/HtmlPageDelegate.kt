package org.geepawhill.html.basic

import org.geepawhill.html.css.Styles
import org.geepawhill.html.model.ContainerTag
import org.geepawhill.html.model.HeadTag
import org.geepawhill.html.model.HtmlPage
import org.geepawhill.html.model.InternalTag

class HtmlPageDelegate(
    override val styles: Styles = StylesDelegate(),
    val delegate: ContainerTag = ContainerTagDelegate("html", styles),
) :
    HtmlPage, ContainerTag by delegate {

    override fun body(details: InternalTag.() -> Unit) {
        val body = InternalTagDelegate(styles = styles, "body")
        body.details()
        +body
    }

    override fun head(details: HeadTag.() -> Unit) {
        val head = HeadTagDelegate(styles)
        head.details()
        +head
    }

    companion object {
        fun page(details: HtmlPageDelegate.() -> Unit): HtmlPage {
            val page = HtmlPageDelegate()
            page.details()
            return page
        }
    }
}
