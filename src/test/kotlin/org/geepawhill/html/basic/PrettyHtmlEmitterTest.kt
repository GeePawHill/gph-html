package org.geepawhill.html.basic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PrettyHtmlEmitterTest {

    val emitter = PrettyHtmlEmitter()

    @Test
    fun `startLine adds`() {
        emitter.startLine()
        emitter.append("a")
        assertThat(emitter.toString()).isEqualTo("\na")
    }

    @Test
    fun `startLine honors indent`() {
        emitter.indent()
        emitter.startLine()
        emitter.append("a")
        assertThat(emitter.toString()).isEqualTo("\n a")
    }

    @Test
    fun `startLine honors dedent`() {
        emitter.indent()
        emitter.startLine()
        emitter.append("a")
        emitter.undent()
        emitter.startLine()
        emitter.append("b")
        assertThat(emitter.toString()).isEqualTo("\n a\nb")
    }
}