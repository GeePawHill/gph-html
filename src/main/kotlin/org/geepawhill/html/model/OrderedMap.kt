package org.geepawhill.html.model

data class KeyValuePair(val key: String, val value: String)

interface OrderedMap : MutableMap<String, String> {
    val ordered: Collection<KeyValuePair>
}
