package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.map.MapVar
import org.junit.jupiter.api.Test

class BasicOrderedMapTest {
    val map = BasicOrderedMap()

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
    fun `classes becomes class on toString`() {
        var classes: String by MapVar("class", map)
        classes = "other"
        assertThat(map.toString()).isEqualTo(" class=\"other\"")
    }
}
