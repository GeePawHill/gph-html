package org.geepawhill.html.css.enums

enum class FontWeightEnum(val realName: String? = null) {
    normal,
    bold,
    bolder,
    lighter,
    ;

    override fun toString(): String = realName ?: name
}
