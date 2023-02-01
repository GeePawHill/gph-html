package org.geepawhill.html.builder

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.basic.AttributeOnlyTagDelegate
import org.geepawhill.html.basic.BasicContainerTag
import org.geepawhill.html.basic.BasicCssSelector
import org.junit.jupiter.api.Test

class FlatPrinterTest {
    val printer = FlatPrinter()

    @Test
    fun `prints AttributeOnlyTag`() {
        val tag = AttributeOnlyTagDelegate("tag").apply {
            attributes["attribute"] = "value"
        }
        assertThat(printer.print(tag)).isEqualTo("<tag attribute=\"value\">")
    }

    @Test
    fun `prints CssSelector`() {
        val tag = BasicCssSelector("*").apply {
            attributes["attribute"] = "value"
        }
        assertThat(printer.print(tag)).isEqualTo("*{attribute: value;}")
    }

    @Test
    fun `prints ContainerTag`() {
        val tag = BasicContainerTag("div").apply {
            +BasicContainerTag("a")
        }
        assertThat(printer.print(tag)).isEqualTo("<div><a></a></div>")
    }
}
