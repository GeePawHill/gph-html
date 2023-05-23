package org.geepawhill.html.css

interface Selector : Rule {
    fun media(query: String, details: MediaQuery.() -> Unit)
    fun under600(details: MediaQuery.() -> Unit)
    fun over600(details: MediaQuery.() -> Unit)
    fun over768(details: MediaQuery.() -> Unit)
    fun over992(details: MediaQuery.() -> Unit)
    fun over1200(details: MediaQuery.() -> Unit)
}
