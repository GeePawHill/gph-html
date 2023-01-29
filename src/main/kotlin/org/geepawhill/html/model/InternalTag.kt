package org.geepawhill.html.model

import org.geepawhill.html.basic.BasicInternalTag
import org.geepawhill.html.map.OrderedMap.Companion.NO_VALUE

typealias Details = InternalTag.() -> Unit

@Suppress("TooManyFunctions")
interface InternalTag : ContainerTag {

    fun div(
        classes: String = NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun input(
        classes: String = NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun label(
        classes: String = NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun i(
        classes: String = NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun img(
        classes: String = NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun h1(
        classes: String = NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun button(
        classes: String = NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun form(
        classes: String = NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun p(
        classes: String = NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun span(
        classes: String = NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun a(
        classes: String = NO_VALUE,
        href: String = NO_VALUE,
        target: String = NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun ul(
        classes: String = NO_VALUE,
        details: Details = NO_DETAILS
    ): BasicInternalTag

    fun li(
        classes: String = NO_VALUE,
        details: Details = NO_DETAILS
    ): BasicInternalTag

    fun nav(classes: String = NO_VALUE, details: Details = NO_DETAILS)

    var classes: String

    companion object {
        val NO_DETAILS: Details = {}
    }
}
