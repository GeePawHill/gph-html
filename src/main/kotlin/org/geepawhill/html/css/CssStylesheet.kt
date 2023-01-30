package org.geepawhill.html.css

import org.geepawhill.html.model.Element

interface CssStylesheet : Element {
    val selectors: MutableList<CssSelector>
    fun selector(selector: String, details: CssSelector.() -> Unit = {})
}
