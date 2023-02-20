package org.geepawhill.html.css

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.css.enums.CursorEnum
import org.geepawhill.html.css.enums.CursorEnum.alias
import org.geepawhill.html.css.enums.GenericEnum.inherit
import org.geepawhill.html.map.OrderedMapDelegate
import org.junit.jupiter.api.Test

class CssPropertyTest {
    val map = OrderedMapDelegate()
    val property = TypedPropertyDelegate<CursorEnum>("cursor", map)

    @Test
    fun `string plusAssign`() {
        property += "Hello"
        assertThat(property.value).isEqualTo("Hello")
    }

    @Test
    fun `universal plusAssign`() {
        property += inherit
        assertThat(property.value).isEqualTo("inherit")
    }

    @Test
    fun `safe plusAssign`() {
        property += alias
        assertThat(property.value).isEqualTo("alias")
    }
}
