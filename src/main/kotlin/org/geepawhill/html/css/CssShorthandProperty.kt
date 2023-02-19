package org.geepawhill.html.css

interface CssShorthandProperty {
    val value: String
    operator fun plusAssign(new: String)
}
