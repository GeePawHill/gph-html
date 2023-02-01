package org.geepawhill.html.map

import org.geepawhill.html.map.OrderedMap.Companion.NO_VALUE
import kotlin.reflect.KProperty

class OrderedMapDelegate : OrderedMap {

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

    inner class Field(private val key: String) : MapField {
        override operator fun <RECEIVER> getValue(field: RECEIVER, property: KProperty<*>): String {
            return this@OrderedMapDelegate[key]!!
        }

        override operator fun <RECEIVER> setValue(field: RECEIVER, property: KProperty<*>, value: String) {
            this@OrderedMapDelegate[key] = value
        }
    }

    inner class Constant(private val key: String, private val constant: String) : MapConstant {
        override operator fun <RECEIVER> getValue(field: RECEIVER, property: KProperty<*>): String {
            this@OrderedMapDelegate[key] = constant
            return constant
        }
    }

    override fun constant(key: String, constant: String): MapConstant = Constant(key, constant)

    override fun field(key: String): MapField = Field(key)

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
