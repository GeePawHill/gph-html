package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BasicPrettyPrinterTest {

    val printer = BasicPrettyPrinter()

    @Test
    fun `prints AttributeOnlyTag`() {
        val tag = BasicAttributeOnlyTag("tag")
        tag.accept(printer)
        assertThat(printer.toString()).isEqualTo("\n<tag>")
    }

    @Test
    fun `prints AttributeOnlyTagWithAttributes`() {
        val tag = BasicAttributeOnlyTag("tag")
        tag.attributes["hey"] = "there"
        tag.accept(printer)
        assertThat(printer.toString()).isEqualTo("\n<tag hey=\"there\">")
    }

    @Test
    fun `prints ContainerTag`() {
        val tag = BasicContainerTag("parent").apply {
            +BasicAttributeOnlyTag("child")
        }
        tag.accept(printer)
        val expected = "\n" + """
            <parent>
              <child>
            </parent>
        """.trimIndent()
        assertThat(printer.toString()).isEqualTo(expected)
    }
}
