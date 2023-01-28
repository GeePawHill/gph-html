package org.geepawhill.html.map

interface OrderedMap : MutableMap<String, String> {
    val ordered: Collection<KeyAndValue>
}
