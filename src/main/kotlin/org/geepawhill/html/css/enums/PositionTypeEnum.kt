package org.geepawhill.html.css.enums

enum class PositionTypeEnum(val value: String? = null) {
    static("static"),
    absolute("absolute"),
    fixed("fixed"),
    relative("relative"),
    sticky("sticky"),
    ;

    override fun toString(): String = value ?: name
}
