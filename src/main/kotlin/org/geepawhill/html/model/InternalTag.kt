package org.geepawhill.html.model

import org.geepawhill.html.basic.BasicInternalTag
import org.geepawhill.html.basic.BasicOrderedMap

typealias Details = InternalTag.() -> Unit

@Suppress("TooManyFunctions")
interface InternalTag : ContainerTag {

    fun div(
        classes: String = BasicOrderedMap.NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun input(
        classes: String = BasicOrderedMap.NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun label(
        classes: String = BasicOrderedMap.NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun i(
        classes: String = BasicOrderedMap.NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun img(
        classes: String = BasicOrderedMap.NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun h1(
        classes: String = BasicOrderedMap.NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun button(
        classes: String = BasicOrderedMap.NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun form(
        classes: String = BasicOrderedMap.NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun p(
        classes: String = BasicOrderedMap.NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun span(
        classes: String = BasicOrderedMap.NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun a(
        classes: String = BasicOrderedMap.NO_VALUE,
        href: String = BasicOrderedMap.NO_VALUE,
        target: String = BasicOrderedMap.NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun ul(
        classes: String = BasicOrderedMap.NO_VALUE,
        details: Details = NO_DETAILS
    ): BasicInternalTag

    fun li(
        classes: String = BasicOrderedMap.NO_VALUE,
        details: Details = NO_DETAILS
    ): BasicInternalTag

    fun nav(classes: String = BasicOrderedMap.NO_VALUE, details: Details = NO_DETAILS)

    var classes: String

    companion object {
        val NO_DETAILS: Details = {}
    }
}
