package org.geepawhill.html.css.enums

enum class AlignmentEnum(val realName: String? = null) {
    left,
    right,
    center,
    justify,
    ;

    override fun toString(): String = realName ?: name
}
