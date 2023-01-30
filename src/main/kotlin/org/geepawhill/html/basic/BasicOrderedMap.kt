package org.geepawhill.html.basic

import org.geepawhill.html.map.KeyAndValue
import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.map.OrderedMap.Companion.NO_VALUE

class BasicOrderedMap :
    OrderedMap {

    private val pairs = mutableListOf<KeyAndValue>()

    override fun get(key: String): String? {
        val index = findKey(key)
        return when (index) {
            -1 -> null
            else -> pairs[index].value
        }
    }

    private fun findKey(key: String): Int {
        pairs.indices.forEach { index ->
            if (pairs[index].key == key) return index
        }
        return -1
    }

    override fun set(key: String, value: String) {
        val index = findKey(key)
        when (index) {
            -1 -> pairs.add(KeyAndValue(key, value))
            else -> pairs[index] = KeyAndValue(key, value)
        }
    }

    override fun forEach(action: (entry: KeyAndValue) -> Unit) {
        pairs.forEach { pair ->
            if (pair.value != NO_VALUE) {
                action(pair)
            }
        }
    }

    override fun toString(): String {
        val result = StringBuilder()
        forEach { entry ->
            result.append(" ${entry.key}=\"${entry.value}\"")
        }
        return result.toString()
    }
}
