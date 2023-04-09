package org.geepawhill.html.model

import org.geepawhill.html.css.Selector
import org.geepawhill.html.css.Styles

interface ContainerTag : AttributeOnlyTag {
    val factory: HtmlFactory
    val elements: List<Element>
    val styles: Styles
    var classes: String
    operator fun Element.unaryPlus()
    operator fun String.unaryPlus()
    operator fun String.unaryMinus()
    fun selector(selector: String, details: Selector.() -> Unit = {})
    fun selectorAs(selector: String)
    fun selectorAs(selector: String, details: Selector.() -> Unit)
}
