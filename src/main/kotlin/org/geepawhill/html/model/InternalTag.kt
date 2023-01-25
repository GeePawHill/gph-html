package org.geepawhill.html.model

import org.geepawhill.html.basic.BasicInternalTag
import org.geepawhill.html.basic.BasicTagAttributes

typealias Details = InternalTag.() -> Unit

interface InternalTag : ContainerTag {

    fun div(
        classes: String = BasicTagAttributes.NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun input(
        classes: String = BasicTagAttributes.NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun label(
        classes: String = BasicTagAttributes.NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun i(
        classes: String = BasicTagAttributes.NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun img(
        classes: String = BasicTagAttributes.NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun h1(
        classes: String = BasicTagAttributes.NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun button(
        classes: String = BasicTagAttributes.NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun form(
        classes: String = BasicTagAttributes.NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun p(
        classes: String = BasicTagAttributes.NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun span(
        classes: String = BasicTagAttributes.NO_VALUE,
        details: Details = NO_DETAILS
    )

    fun a(
        classes: String = BasicTagAttributes.NO_VALUE,
        href: String = BasicTagAttributes.NO_VALUE,
        target: String = BasicTagAttributes.NO_VALUE,
        details: Details = NO_DETAILS
    )


    fun ul(
        classes: String = BasicTagAttributes.NO_VALUE,
        details: Details = NO_DETAILS
    ): BasicInternalTag

    fun li(
        classes: String = BasicTagAttributes.NO_VALUE,
        details: Details = NO_DETAILS
    ): BasicInternalTag

    fun nav(classes: String = BasicTagAttributes.NO_VALUE, details: Details = NO_DETAILS)

    var classes: String

    companion object {
        val NO_DETAILS: Details = {}
    }
}