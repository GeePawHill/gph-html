package org.geepawhill.html.css

import org.geepawhill.html.css.enums.GenericEnum

interface ShorthandProperty {
    val value: String
    operator fun plusAssign(new: String)
    operator fun plusAssign(universal: GenericEnum)
}
