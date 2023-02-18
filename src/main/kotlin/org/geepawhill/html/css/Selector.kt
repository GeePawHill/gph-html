package org.geepawhill.html.css

interface Selector : Rule {
    fun media(query: String, details: MediaQuery.() -> Unit)
    fun small(details: MediaQuery.() -> Unit)
    fun medium(details: MediaQuery.() -> Unit)
    fun large(details: MediaQuery.() -> Unit)
    fun huge(details: MediaQuery.() -> Unit)
}
