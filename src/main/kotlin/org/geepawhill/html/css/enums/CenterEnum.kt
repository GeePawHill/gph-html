package org.geepawhill.html.css.enums

enum class CenterEnum(val realName: String? = null) {
    center
    ;

    override fun toString(): String = realName ?: name
}
