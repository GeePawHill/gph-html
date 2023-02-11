package org.geepawhill.html.css

interface Selector : Rule {
    fun media(query: String, details: MediaQuery.() -> Unit)
}
