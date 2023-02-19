package org.geepawhill.html.css

import org.geepawhill.html.css.enums.GenericEnum

interface CssSafeProperty<TYPE> {
    val value: String
    operator fun plusAssign(raw: String)
    operator fun plusAssign(universal: GenericEnum)
    operator fun plusAssign(safe: TYPE)
}
