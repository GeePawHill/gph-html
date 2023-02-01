package org.geepawhill.html.model

import org.geepawhill.html.css.Selector
import org.geepawhill.html.css.Stylesheet

interface ContainerTag : AttributeOnlyTag {
    val elements: MutableList<Element>
    val stylesheet: Stylesheet
    operator fun Element.unaryPlus()
    operator fun String.unaryPlus()
    operator fun String.unaryMinus()
    fun selector(selector: String, details: Selector.() -> Unit = {})
}
