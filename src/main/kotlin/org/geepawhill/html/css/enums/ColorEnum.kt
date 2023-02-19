package org.geepawhill.html.css.enums

enum class ColorEnum(val value: String? = null) {
    white("white"),
    ;

    override fun toString(): String = value ?: name
}
