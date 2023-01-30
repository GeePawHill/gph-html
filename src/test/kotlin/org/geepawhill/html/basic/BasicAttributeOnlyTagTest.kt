package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.map.MapVar
import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.map.OrderedMap.Companion.NO_VALUE
import org.junit.jupiter.api.Test

class BasicAttributeOnlyTagTest {

    class TestingTag(
        href: String = NO_VALUE,
        val attributes: OrderedMap = BasicOrderedMap()
    ) :
        OrderedMap by attributes {
        var href: String by MapVar("href", attributes)

        init {
            this.href = href
        }

        override fun toString(): String = attributes.toString()
    }

    @Test
    fun `add by field assignment`() {
        val tag = TestingTag("href")
        tag.href = "trythis"
        tag["second"] = "secondValue"
        assertThat(tag.attributes.toString()).isEqualTo(" href=\"trythis\" second=\"secondValue\"")
    }

    @Test
    fun `add by constructor`() {
        val newTag = TestingTag("xyzzy")
        assertThat(newTag.toString()).isEqualTo(" href=\"xyzzy\"")
    }
}
