package org.geepawhill.html.css

import org.geepawhill.html.model.Element

interface Styles : Element {
    val selectors: MutableList<Selector>
    val queries: MutableList<MediaQuery>
    fun selector(rule: String, details: Selector.() -> Unit = {})
}
