package org.geepawhill.html

import org.geepawhill.html.basic.HtmlPageDelegate
import org.geepawhill.html.css.DisplayEnum.block
import org.geepawhill.html.css.DisplayEnum.inline
import org.geepawhill.html.model.Element.Companion.pretty
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
                        media("only screen and (min-width: 600px)") {
                            display += inline
                        }
                    }
                    nav("silly") {
                        selector(".silly") {
                            declarations["width"] = "100px"
                        }
                    }
                }
            }
        }
        println(page.pretty)
    }
}
