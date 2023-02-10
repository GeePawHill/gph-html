package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap

interface MediaQuery : CssElement {
    val rule: String
    val selector: String
    val declarations: OrderedMap
}
