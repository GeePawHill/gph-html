package org.geepawhill.html.basic

import org.geepawhill.html.model.HtmlEmitter

class BasicHtmlEmitter(val appendable: Appendable = StringBuilder()) : HtmlEmitter, Appendable by appendable {

}