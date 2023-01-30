package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.map.BasicOrderedMap
import org.geepawhill.html.map.MapConstant
import org.geepawhill.html.map.MappedField
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

    @Suppress("UNUSED_VARIABLE")
    @Test
    fun `mapval sets on de-reference`() {
        val access: String by MapConstant("something", "meaning", map)
        val x = access
        assertThat(map["something"]).isEqualTo("meaning")
    }

    @Test
    fun `mapvar adds to map`() {
        var access: String by MappedField("something", map)
        access = "meaning"
        assertThat(map["something"]).isEqualTo("meaning")
    }

    @Test
    fun `classes becomes class on toString`() {
        var classes: String by MappedField("class", map)
        classes = "other"
        assertThat(map.toString()).isEqualTo(" class=\"other\"")
    }
}
