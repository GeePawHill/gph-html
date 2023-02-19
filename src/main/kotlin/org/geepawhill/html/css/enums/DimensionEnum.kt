package org.geepawhill.html.css.enums

enum class DimensionEnum(val value: String? = null) {
    auto,
    ;

    override fun toString(): String = value ?: name
}
