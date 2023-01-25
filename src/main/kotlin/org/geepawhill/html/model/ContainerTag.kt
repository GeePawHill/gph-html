package org.geepawhill.html.model

interface ContainerTag : AttributeTag {
    val elements: MutableList<Element>
    operator fun Element.unaryPlus()
    operator fun String.unaryPlus()
    operator fun String.unaryMinus()
}