package org.geepawhill.html.model

interface Element {
    fun emit(builder: StringBuilder = StringBuilder()): String
}