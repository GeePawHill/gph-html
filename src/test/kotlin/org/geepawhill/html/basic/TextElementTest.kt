package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.model.Element.Companion.flat
import org.geepawhill.html.model.TextElement
import org.junit.jupiter.api.Test

class TextElementTest {
    @Test
    fun `provides raw output`() {
        assertThat(TextElement("abc").flat).isEqualTo("abc")
    }
}
