package org.geepawhill.html.css.enums

enum class BoxSizingEnum(val value: String? = null) {
    content_box("content-box"),
    border_box("border-box"),
    ;

    override fun toString(): String = value ?: name
}
