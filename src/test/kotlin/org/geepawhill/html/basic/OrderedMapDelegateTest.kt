package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.map.OrderedMapDelegate
import org.junit.jupiter.api.Test

class OrderedMapDelegateTest {
    val map = OrderedMapDelegate()

    @Test
    fun `basic add works`() {
        map["something"] = "other"
        assertThat(map["something"]).isEqualTo("other")
    }

    @Test
    fun `multiple adds works`() {
        map["first"] = "firstValue"
        map["second"] = "secondValue"
        val keys = mutableListOf<String>()
        map.forEach { entry -> keys.add(entry.key) }
        assertThat(keys).containsExactly("first", "second")
    }

    @Test
    fun `add order is significant`() {
        map["second"] = "secondValue"
        map["first"] = "firstValue"
        val keys = mutableListOf<String>()
        map.forEach { entry -> keys.add(entry.key) }
        assertThat(keys).containsExactly("second", "first")
    }

    @Test
    fun `add duplicates replaced`() {
        map["second"] = "secondValue"
        map["second"] = "changed my mind"
        assertThat(map["second"]).isEqualTo("changed my mind")
    }

    @Test
    fun `key determines map index`() {
        var classes: String by map.field("class")
        classes = "other"
        assertThat(map["class"]).isEqualTo("other")
    }

    @Suppress("UNUSED_EXPRESSION")
    @Test
    fun `constants work on access`() {
        var field: String by map.field("field")
        val constant: String by map.constant("field", "constant")
        field = "assigned"
        assertThat(map["field"]).isEqualTo("assigned")
        constant
        assertThat(map["field"]).isEqualTo("constant")
    }
}
