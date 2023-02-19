package org.geepawhill.html.css.enums

enum class GenericEnum(val value: String? = null) {
    none("none"),
    unset("unset"),
    initial("initial"),
    inherit("inherit"),
    ;

    override fun toString(): String = value ?: name
}
