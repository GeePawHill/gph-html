package org.geepawhill.html.css

import org.geepawhill.html.model.Element

interface Styles : Element {
    val selectors: List<Selector>
    val queries: List<MediaQuery>
    fun selector(rule: String, details: Selector.() -> Unit = {})
    operator fun Selector.unaryPlus()
    operator fun MediaQuery.unaryPlus()
}
