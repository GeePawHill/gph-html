package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.builder.FlatPrinter
import org.geepawhill.html.model.EncodedTextElement
import org.junit.jupiter.api.Test

class EncodedTextElementTest {

    val printer = FlatPrinter()

    @Test
    fun `encodes its argument on emit`() {
        val element = EncodedTextElement("&")
        assertThat(printer.print(element)).isEqualTo("%26")
    }
}
