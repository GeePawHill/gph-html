package org.geepawhill.html.css

import org.geepawhill.html.model.AttributeOnlyTag

interface Selector : AttributeOnlyTag {
    val display: DisplayDeclaration
}
