package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.map.OrderedMap
import org.geepawhill.html.map.OrderedMap.Companion.NO_VALUE
import org.geepawhill.html.map.OrderedMapDelegate
import org.junit.jupiter.api.Test

class AttributeOnlyTagDelegateTest {

    class TestingTag(
        href: String = NO_VALUE,
        val attributes: OrderedMap = OrderedMapDelegate()
    ) :
        OrderedMap by attributes {
        var href: String by attributes.field("href")

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
