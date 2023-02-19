package org.geepawhill.html.css

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.map.OrderedMapDelegate
import org.junit.jupiter.api.Test

class ColorDeclarationTest {

    val map = OrderedMapDelegate()
    val color = ColorDeclaration("color", map)

    @Test
    fun `formats hex`() {
        color += 0x010203
        assertThat(color.value).isEqualTo("#010203")
    }
}
