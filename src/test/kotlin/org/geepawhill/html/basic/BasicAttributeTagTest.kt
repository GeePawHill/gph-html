package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.basic.BasicTagAttributes
import org.geepawhill.html.model.TagAttributes
import org.junit.jupiter.api.Test

class BasicAttributeTagTest {

    class TestingTag(
        href: String = BasicTagAttributes.NO_VALUE,
        val attributes: TagAttributes = BasicTagAttributes()
    ) :
        TagAttributes by attributes {
        var href: String by attributes

        init {
            this.href = href
        }

        override fun toString(): String = attributes.toString()
    }

    @Test
    fun `add by field`() {
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