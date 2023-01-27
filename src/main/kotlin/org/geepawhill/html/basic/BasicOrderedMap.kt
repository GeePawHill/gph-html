package org.geepawhill.html.basic

import org.geepawhill.html.model.KeyAndValue
import org.geepawhill.html.model.OrderedMap

class BasicOrderedMap(private val map: MutableMap<String, String> = mutableMapOf()) :
    OrderedMap, MutableMap<String, String> by map {
    private val keysAdded = mutableListOf<String>()

    override val ordered: Collection<KeyAndValue>
        get() {
            val result = mutableListOf<KeyAndValue>()
            keysAdded.forEach { key ->
                val value = this[key]
                if (value != null && value != NO_VALUE) {
                    if (key == "classes") {
                        result.add(KeyAndValue("class", value))
                    } else {
                        result.add(KeyAndValue(key, value))
                    }
                }
            }
            return result
        }

    override fun put(key: String, value: String): String? {
        if (!keysAdded.contains(key)) keysAdded.add(key)
        return map.put(key, value)
    }

    override fun putAll(from: Map<out String, String>) {
        from.forEach { entry ->
            put(entry.key, entry.value)
        }
    }

    override fun remove(key: String): String? {
        return map.remove(key)
    }

    override fun toString(): String {
        val result = StringBuilder()
        ordered.forEach { entry ->
            result.append(" ${entry.key}=\"${entry.value}\"")
        }
        return result.toString()
    }

    override fun clear() {
        map.clear()
        keysAdded.clear()
    }

    companion object {
        const val NO_VALUE = "NO-VALUE-SET-HERE"
    }
}
