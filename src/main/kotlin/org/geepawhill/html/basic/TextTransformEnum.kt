package org.geepawhill.html.basic

enum class TextTransformEnum(val realName: String? = null) {
    capitalize,
    uppercase,
    lowercase,
    ;

    override fun toString(): String = realName ?: name
}
