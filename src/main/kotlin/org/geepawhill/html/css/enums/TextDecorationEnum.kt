package org.geepawhill.html.css.enums

enum class TextDecorationEnum(val value: String? = null) {
    none("none"),
    overline("overline"),
    line_through("line-through"),
    underline("underline"),
    inherit("inherit"),
    ;

    operator fun plus(other: TextDecorationEnum): String {
        return this.value + " " + other.value
    }
}
