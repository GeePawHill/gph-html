package org.geepawhill.html.basic

import org.geepawhill.html.css.Selector
import org.geepawhill.html.map.OrderedMap.Companion.NO_VALUE
import org.geepawhill.html.model.ContainerTag
import org.geepawhill.html.model.Details
import org.geepawhill.html.model.HtmlFactory
import org.geepawhill.html.model.InternalTag
import org.geepawhill.html.model.InternalTag.Companion.NO_DETAILS

@Suppress("TooManyFunctions")
class InternalTagDelegate(
    tag: String,
    classes: String,
    override val factory: HtmlFactory,
) :
    InternalTag, ContainerTag by factory.containerTag(tag) {

    override val id: SimpleAttribute = SimpleAttribute(attributes, "id")

    init {
        this.classes += classes
    }

    override fun asClass(className: String, details: Selector.() -> Unit) {
        classes += className
        selector(".$className", details)
    }

    override fun asClass(className: String) {
        classes += className
    }

    override fun asId(idString: String, details: Selector.() -> Unit) {
        id += idString
        selector("#$idString", details)
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
        +factory.linkTag(classes, href, target).apply(details)
    }

    override fun ul(
        classes: String,
        details: InternalTag.() -> Unit
    ) {
        runAndAdd("ul", classes, details)
    }

    override fun li(
        classes: String,
        details: InternalTag.() -> Unit
    ) {
        runAndAdd("li", classes, details)
    }

    private fun runAndAdd(tag: String, classes: String = NO_VALUE, details: Details = NO_DETAILS) {
        +factory.internalTag(tag, classes).apply(details)
    }
}
