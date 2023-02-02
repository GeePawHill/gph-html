package org.geepawhill.html

import org.geepawhill.html.basic.HtmlPageDelegate
import org.geepawhill.html.builder.BasicPrettyPrinter
import org.geepawhill.html.css.DisplayEnum.block
import org.junit.jupiter.api.Test

class Sketchbook {
    @Test
    fun `a sample page`() {
        val page = HtmlPageDelegate.page {
            head {
                stylesheet {
                    selector("*") {
                        display += block
                    }
                }
            }
            body {
                div("stinky") {
                    selector(".stinky") {
                        display += block
                    }
                    nav("silly") {
                        selector(".silly") {
                            attributes["width"] = "100px"
                        }
                    }
                }
            }
        }
        println(BasicPrettyPrinter().print(page))
    }
}
