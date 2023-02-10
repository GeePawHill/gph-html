package org.geepawhill.html.css

import org.geepawhill.html.model.Element

interface Styles : Element {
    val selectors: MutableList<Selector>
    val queries: MutableList<MediaQuery>
    fun selector(selector: String, details: Selector.() -> Unit = {})
}
