package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.model.EncodedTextElement
import org.junit.jupiter.api.Test

class EncodedTextElementTest {

    @Test
    fun `encodes its argument`() {
        assertThat(EncodedTextElement("&").flat).isEqualTo("%26")
    }
}
