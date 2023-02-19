package org.geepawhill.html.css.enums

enum class BorderStyleEnum(val value: String? = null) {
    hidden("hidden"),
    dotted("dotted"),
    dashed("dashed"),
    solid("solid"),
    double("double"),
    groove("groove"),
    ridge("ridge"),
    inset("inset"),
    outset("outset")

    ;

    override fun toString(): String = value ?: name
}
