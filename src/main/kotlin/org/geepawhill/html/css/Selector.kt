package org.geepawhill.html.css

interface Selector : Declarations {
    fun media(query: String, details: MediaQuery.() -> Unit)
}
