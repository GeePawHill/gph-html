package org.geepawhill.html.basic

import org.junit.jupiter.api.Test

class BasicCssSelectorTest {
    val printer = BasicPrettyPrinter()
    val selector = BasicCssSelector("*")

    @Test
    fun `empty selector works`() {
        selector.accept(printer)
        println(printer.toString())
    }

    @Test
    fun `direct set works`() {
        selector.apply {
            attributes["width"] = "10px"
        }
        selector.accept(printer)
        println(printer.toString())
    }

    @Test
    fun `display field works`() {
        selector.apply {
            display.none
        }
        selector.accept(printer)
        println(printer.toString())
    }
}
