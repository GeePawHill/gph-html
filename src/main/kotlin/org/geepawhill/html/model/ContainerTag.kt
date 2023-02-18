package org.geepawhill.html.model

import org.geepawhill.html.css.Selector
import org.geepawhill.html.css.SimpleDeclaration
import org.geepawhill.html.css.Styles

interface ContainerTag : AttributeOnlyTag {
    val elements: List<Element>
    val styles: Styles
    val classes: SimpleDeclaration
    operator fun Element.unaryPlus()
    operator fun String.unaryPlus()
    operator fun String.unaryMinus()
    fun selector(selector: String, details: Selector.() -> Unit = {})
    fun selectorAs(selector: String)
    fun selectorAs(selector: String, details: Selector.() -> Unit)
}
