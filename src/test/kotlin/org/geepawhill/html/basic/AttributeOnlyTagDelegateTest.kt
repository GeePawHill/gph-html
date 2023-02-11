package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.model.Element.Companion.flat
import org.junit.jupiter.api.Test

class AttributeOnlyTagDelegateTest {

    @Test
    fun `flat format`() {
        val tag = AttributeOnlyTagDelegate("tag").apply {
            attributes["href"] = "#"
        }
        assertThat(tag.flat).isEqualTo("<tag href=\"#\">")
    }
}
