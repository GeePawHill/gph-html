package org.geepawhill.html.model

import org.geepawhill.html.map.KeyAndValue

@Suppress("TooManyFunctions")
interface HtmlFormatter {
    fun emptyTag(tag: String, attributes: Collection<KeyAndValue>)
    fun text(text: String)
    fun openContainerTag(tag: String, attributes: Collection<KeyAndValue>)
    fun closeContainerTag(tag: String)
    fun openSelector(rule: String)
    fun closeSelector()
    fun declaration(declaration: KeyAndValue)
    fun startStyles()
    fun endStyles()
    fun startRule(rule: String)
    fun endRule()
    fun startQuery(query: String)
    fun endQuery()
}
