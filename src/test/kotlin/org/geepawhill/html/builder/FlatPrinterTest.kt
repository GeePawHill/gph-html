package org.geepawhill.html.builder

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.basic.AttributeOnlyTagDelegate
import org.geepawhill.html.basic.ContainerTagDelegate
import org.geepawhill.html.basic.SelectorDelegate
import org.geepawhill.html.basic.StylesDelegate
import org.junit.jupiter.api.Test

class FlatPrinterTest {
    val printer = FlatPrinter()
    val styles = StylesDelegate()

    @Test
    fun `prints AttributeOnlyTag`() {
        val tag = AttributeOnlyTagDelegate("tag").apply {
            attributes["attribute"] = "value"
        }
        assertThat(printer.print(tag)).isEqualTo("<tag attribute=\"value\">")
    }

    @Test
    fun `prints CssSelector`() {
        val tag = SelectorDelegate(styles, "*").apply {
            declarations["attribute"] = "value"
        }
        assertThat(printer.print(tag)).isEqualTo("*{attribute: value;}")
    }

    @Test
    fun `prints ContainerTag`() {
        val tag = ContainerTagDelegate("div", styles).apply {
            +ContainerTagDelegate("a", styles)
        }
        assertThat(printer.print(tag)).isEqualTo("<div><a></a></div>")
    }
}
