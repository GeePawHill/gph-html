package org.geepawhill.html.css.enums

enum class AlignItemsEnum(val realName: String? = null) {
    normal,
    stretch,
    center,
    flex_start("flex-start"),
    flex_end("flex-dend"),
    start,
    end,
    baseline,
    ;

    override fun toString(): String = realName ?: name
}
