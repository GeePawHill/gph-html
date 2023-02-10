package org.geepawhill.html.basic

import org.geepawhill.html.css.Styles
import org.geepawhill.html.map.OrderedMap.Companion.NO_VALUE
import org.geepawhill.html.model.ContainerTag
import org.geepawhill.html.model.Details
import org.geepawhill.html.model.InternalTag
import org.geepawhill.html.model.InternalTag.Companion.NO_DETAILS

@Suppress("TooManyFunctions")
class InternalTagDelegate(
    styles: Styles,
    tag: String,
    classes: String = NO_VALUE,
    private val delegate: ContainerTag = ContainerTagDelegate(tag, styles)
) :
    InternalTag, ContainerTag by delegate {

    override var classes: String by attributes.field("class")

    init {
        this.classes = classes
    }

    override fun toString(): String {
        return tag
    }

    override fun nav(classes: String, details: Details) {
        runAndAdd("nav", classes, details)
    }

    override fun div(classes: String, details: Details) {
        runAndAdd("div", classes, details)
    }

    override fun input(classes: String, details: Details) {
        runAndAdd("input", classes, details)
    }

    override fun label(classes: String, details: Details) {
        runAndAdd("label", classes, details)
    }

    override fun i(classes: String, details: Details) {
        runAndAdd("i", classes, details)
    }

    override fun h1(classes: String, details: Details) {
        runAndAdd("h1", classes, details)
    }

    override fun button(classes: String, details: Details) {
        runAndAdd("button", classes, details)
    }

    override fun form(classes: String, details: Details) {
        runAndAdd("form", classes, details)
    }

    override fun img(classes: String, details: Details) {
        runAndAdd("img", classes, details)
    }

    override fun span(classes: String, details: Details) {
        runAndAdd("span", classes, details)
    }

    override fun p(classes: String, details: Details) {
        runAndAdd("p", classes, details)
    }

    override fun a(
        classes: String,
        href: String,
        target: String,
        details: Details
    ) {
        elements.add(LinkTagDelegate(styles, classes, href, target).apply(details))
    }

    override fun ul(
        classes: String,
        details: InternalTag.() -> Unit
    ): InternalTagDelegate {
        val tag = InternalTagDelegate(styles, "ul", classes)
        tag.details()
        elements.add(tag)
        return tag
    }

    override fun li(
        classes: String,
        details: InternalTag.() -> Unit
    ): InternalTagDelegate {
        val tag = InternalTagDelegate(styles, "li", classes)
        tag.details()
        elements.add(tag)
        return tag
    }

    private fun runAndAdd(tag: String, classes: String = NO_VALUE, details: Details = NO_DETAILS) {
        val toAdd = InternalTagDelegate(styles, tag, classes)
        toAdd.details()
        elements.add(toAdd)
    }
}
