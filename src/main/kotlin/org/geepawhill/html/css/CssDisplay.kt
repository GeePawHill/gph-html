package org.geepawhill.html.css

import org.geepawhill.html.map.OrderedMap

@Suppress("TooManyFunctions", "VariableNaming")
class CssDisplay(val map: OrderedMap) {
    var value: String by map.field("display")
    val none: String by map.constant("display", "none")
    val inline: String by map.constant("display", "inline")
    val block: String by map.constant("display", "block")
    val contents: String by map.constant("display", "contents")
    val flex: String by map.constant("display", "flex")
    val grid: String by map.constant("display", "grid")
    val inline_block by map.constant("display", "inline-block")
    val inline_flex by map.constant("display", "inline-flex")
    val inline_grid by map.constant("display", "inline-grid")
    val inline_table by map.constant("display", "inline-table")
    val list_item by map.constant("display", "list-item")
    val run_in by map.constant("display", "run-in")
    val table by map.constant("display", "table")
    val table_caption by map.constant("display", "table-caption")
    val table_column_group by map.constant("display", "table-column-group")
    val table_header_group by map.constant("display", "table-header-group")
    val table_footer_group by map.constant("display", "table-footer-group")
    val table_row_group by map.constant("display", "table-row-group")
    val table_cell by map.constant("display", "table-cell")
    val table_column by map.constant("display", "table-column")
    val table_row by map.constant("display", "table-row")
    val initial by map.constant("display", "initial")
    val inherit by map.constant("display", "inherit")
}
