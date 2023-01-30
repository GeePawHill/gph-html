package org.geepawhill.html

import org.geepawhill.html.basic.BasicHtmlPage
import org.geepawhill.html.builder.BasicPrettyPrinter
import org.junit.jupiter.api.Test

class Sketchbook {
    @Test
    fun `a sample page`() {
        val page = BasicHtmlPage.page {
            head {
                stylesheet {
                    selector(".stinky") {
                        display.block
                    }
                }
            }
            body {
                div("stinky") {
                }
            }
        }
        println(BasicPrettyPrinter().print(page))
    }
}
