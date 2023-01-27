package org.geepawhill.html.model

data class KeyAndValue(val key: String, val value: String)

interface OrderedMap : MutableMap<String, String> {
    val ordered: Collection<KeyAndValue>
}
