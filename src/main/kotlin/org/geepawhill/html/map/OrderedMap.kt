package org.geepawhill.html.map

interface OrderedMap {
    operator fun get(key: String): String?
    operator fun set(key: String, value: String)

    fun forEach(action: (entry: KeyAndValue) -> Unit)

    companion object {
        const val NO_VALUE = "NO-VALUE-SET-HERE"
    }
}
