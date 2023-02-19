package org.geepawhill.html.css.enums

enum class VerticalAlignEnum(val value: String? = null) {
    baseline,
    sub,
    `super`,
    top,
    text_top("text-top"),
    middle,
    bottom,
    text_bottom("text-bottom")
    ;

    override fun toString(): String = value ?: name
}
