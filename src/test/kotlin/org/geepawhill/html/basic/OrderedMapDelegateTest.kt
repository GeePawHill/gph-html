package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.map.OrderedMapDelegate
import org.junit.jupiter.api.Test

class OrderedMapDelegateTest {
    val map = OrderedMapDelegate()

    @Test
    fun `basic add works`() {
        map["something"] = "other"
        assertThat(map.toString()).isEqualTo(" something=\"other\"")
    }

    @Test
    fun `multiple adds works`() {
        map["first"] = "firstValue"
        map["second"] = "secondValue"
        assertThat(map.toString()).isEqualTo(" first=\"firstValue\" second=\"secondValue\"")
    }

    @Test
    fun `add order is significant`() {
        map["second"] = "secondValue"
        map["first"] = "firstValue"
        assertThat(map.toString()).isEqualTo(" second=\"secondValue\" first=\"firstValue\"")
    }

    @Test
    fun `add duplicates replaced`() {
        map["second"] = "secondValue"
        map["second"] = "changed my mind"
        assertThat(map.toString()).isEqualTo(" second=\"changed my mind\"")
    }

    @Test
    fun `mapvar adds to map`() {
        var access: String by map.field("something")
        access = "meaning"
        assertThat(map["something"]).isEqualTo("meaning")
    }

    @Test
    fun `classes becomes class on toString`() {
        var classes: String by map.field("class")
        classes = "other"
        assertThat(map.toString()).isEqualTo(" class=\"other\"")
    }
}
