package org.geepawhill.html.css.enums

enum class JustifyContentEnum(val realName: String? = null) {
    flex_start("flex-start"),
    flex_end("flex-end"),

    // center
    space_between("space-between"),
    space_around("space-around"),
    space_evenly("space-evently"),
    ;

    override fun toString(): String = realName ?: name
}
