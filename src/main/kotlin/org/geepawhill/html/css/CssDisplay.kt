package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap

@Suppress("TooManyFunctions", "FunctionNaming")
class CssDisplay(val map: OrderedMap) {
    var value: String by map.field("display")

    fun none() {
        value = "none"
    }

    fun inline() {
        value = "inline"
    }

    fun block() {
        value = "block"
    }

    fun contents() {
        value = "contents"
    }

    fun flex() {
        value = "flex"
    }

    fun grid() {
        value = "grid"
    }

    fun inline_block() {
        value = "inline-block"
    }

    fun inline_flex() {
        value = "inline-flex"
    }

    fun inline_grid() {
        value = "inline-grid"
    }

    fun inline_table() {
        value = "inline-table"
    }

    fun list_item() {
        value = "list-item"
    }

    fun run_in() {
        value = "run-in"
    }

    fun table() {
        value = "table"
    }

    fun table_caption() {
        value = "table-caption"
    }

    fun table_column_group() {
        value = "table-column-group"
    }

    fun table_header_group() {
        value = "table-header-group"
    }

    fun table_footer_group() {
        value = "table-footer-group"
    }

    fun table_row_group() {
        value = "table-row-group"
    }

    fun table_cell() {
        value = "table-cell"
    }

    fun table_column() {
        value = "table-column"
    }

    fun table_row() {
        value = "table-row"
    }

    fun initial() {
        value = "initial"
    }

    fun inherit() {
        value = "inherit"
    }
}
