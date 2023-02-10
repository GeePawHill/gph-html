package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.builder.BasicPrettyPrinter
import org.junit.jupiter.api.Test

class BasicPrettyPrinterTest {

    val printer = BasicPrettyPrinter()
    val styles = StylesDelegate()

    @Test
    fun `prints AttributeOnlyTag`() {
        val tag = AttributeOnlyTagDelegate("tag")
        tag.accept(printer)
        assertThat(printer.toString()).isEqualTo("\n<tag>")
    }

    @Test
    fun `prints AttributeOnlyTagWithAttributes`() {
        val tag = AttributeOnlyTagDelegate("tag")
        tag.attributes["hey"] = "there"
        tag.accept(printer)
        assertThat(printer.toString()).isEqualTo("\n<tag hey=\"there\">")
    }

    @Test
    fun `prints ContainerTag`() {
        val tag = ContainerTagDelegate("parent", styles).apply {
            +AttributeOnlyTagDelegate("child")
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
