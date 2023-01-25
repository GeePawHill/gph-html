package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BasicInternalTagTest {

    @Test
    fun `nested tags work`() {
        val tag = BasicInternalTag("div").apply {
            +BasicInternalTag("li")
        }
        assertThat(tag.elements).hasSize(1)
        assertThat(tag.emit()).isEqualTo("<div><li></li></div>")
    }

    @Test
    fun `nested tags with dsl`() {
        val tag = BasicInternalTag("div").apply {
            ul {
                li { }
                +"Hello"
            }
        }
        assertThat(tag.elements).hasSize(1)
        assertThat(tag.emit()).isEqualTo("<div><ul><li></li>Hello</ul></div>")
    }

    @Test
    fun `nested texts work`() {
        val tag = BasicInternalTag("div").apply {
            +"hello"
        }
        assertThat(tag.elements).hasSize(1)
        assertThat(tag.emit()).isEqualTo("<div>hello</div>")
    }
}
