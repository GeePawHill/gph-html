package org.geepawhill.html.map

/**
 * OrderedMap is a light map-like class that keeps the order in which the keys were
 * added, and uses that order in its forEach iterator.
 * It is comparable to [java.util.LinkedHashMap], but with a more narrow interface.
 */
interface OrderedMap {
    /**
     * Returns the KeyAndValue pairs, excluding those set to NO_VALUE, in the order in which
     * they were added.
     */
    val entries: Collection<KeyAndValue>

    /**
     * Kotlin operator for getting, i.e. @code { val x = map["key"] }
     */
    operator fun get(key: String): String?

    /**
     * Kotlin operator for setting, i.e. @code { map["key"] = "value"}
     */
    operator fun set(key: String, value: String)

    /**
     * Supplies a property delegate to store & retrieve a string from the given key
     */
    fun field(key: String): MapField
    fun constant(key: String, constant: String): MapConstant

    companion object {
        /**
         * An arbitrary unusual string. This allows us to add an entry for a key,
         * in order to ensure its order in forEach, without actually setting its value.
         *
         * If it's value is eventually set, the forEach will retain the order of when it
         * was declared instead of when it was set to a valid item.
         *
         * In the snippet below, the map's forEach will process the first key and value before
         * it processes the second key and value.
         *
         * @code {
         * map["first"] = NO_VALUE
         * map["second"] = "second value"
         * map["first"] = "first value"
         * }
         *
         *
         */
        const val NO_VALUE = "NO-VALUE-SET-HERE"
    }
}
