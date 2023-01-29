package org.geepawhill.html.map

interface OrderedMap : MutableMap<String, String> {
    val ordered: Collection<KeyAndValue>

    companion object {
        const val NO_VALUE = "NO-VALUE-SET-HERE"
    }
}
