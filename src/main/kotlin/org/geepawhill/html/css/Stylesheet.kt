package org.geepawhill.html.css

import org.geepawhill.html.model.Element

interface Stylesheet : Element {
    val selectors: MutableList<Selector>
    fun selector(selector: String, details: Selector.() -> Unit = {})
}
