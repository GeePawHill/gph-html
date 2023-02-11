package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.geepawhill.html.model.Element.Companion.flat
import org.junit.jupiter.api.Test

class ContainerTagDelegateTest {
    val tag = ContainerTagDelegate("tag", StylesDelegate())

    @Test
    fun `formats flat correctly`() {
        assertThat(tag.flat).isEqualTo("<tag></tag>")
    }

    @Test
    fun `formats flat with attributes`() {
        tag.apply {
            attributes["key"] = "value"
        }
        assertThat(tag.flat).isEqualTo("<tag key=\"value\"></tag>")
    }

    @Test
    fun `formats flat with contents`() {
        val styles = StylesDelegate()
        val tag = ContainerTagDelegate("tag", styles).apply {
            +ContainerTagDelegate("child", styles)
        }
        assertThat(tag.flat).isEqualTo("<tag><child></child></tag>")
    }
}
