package org.geepawhill.html.model

import org.geepawhill.html.css.CssSelector
import org.geepawhill.html.css.CssStylesheet

interface ContainerTag : AttributeOnlyTag {
    val elements: MutableList<Element>
    val stylesheet: CssStylesheet
    operator fun Element.unaryPlus()
    operator fun String.unaryPlus()
    operator fun String.unaryMinus()
    fun selector(selector: String, details: CssSelector.() -> Unit = {})
}
