package org.geepawhill.html.model

interface ContainerTag : AttributeOnlyTag {
    val elements: MutableList<Element>
    operator fun Element.unaryPlus()
    operator fun String.unaryPlus()
    operator fun String.unaryMinus()
}
