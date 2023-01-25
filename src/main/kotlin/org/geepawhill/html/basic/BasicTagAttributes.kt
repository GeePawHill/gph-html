package org.geepawhill.html.basic

import org.geepawhill.html.model.TagAttributes

class BasicTagAttributes(private val map: MutableMap<String, String> = mutableMapOf()) : TagAttributes,
    MutableMap<String, String> by map {
    private val keysAdded = mutableListOf<String>()

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
        for (key in keysAdded) {
            val value = this[key]
            if (value != null && value != NO_VALUE) {
                if (key == "classes") result.append(" class=\"$value\"")
                else result.append(" $key=\"$value\"")
            }
        }
        return result.toString()
    }

    override val entries: MutableSet<MutableMap.MutableEntry<String, String>>
        get() = map.entries
    override val keys: MutableSet<String>
        get() = map.keys
    override val size: Int
        get() = map.size
    override val values: MutableCollection<String>
        get() = map.values

    override fun clear() {
        map.clear()
        keysAdded.clear()
    }

    companion object {
        val NO_VALUE = "NO-VALUE-SET-HERE"
    }
}