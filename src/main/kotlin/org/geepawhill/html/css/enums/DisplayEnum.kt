package org.geepawhill.html.css.enums

enum class DisplayEnum(val value: String? = null) {

    `inline`("inline"),
    block("block"),
    contents("contents"),
    flex("flex"),
    grid("grid"),
    inline_block("inline-block"),
    inline_flex("inline-flex"),
    inline_grid("inline-grid"),
    inline_table("inline-table"),
    list_item("list-item"),
    run_in("run-in"),
    table("table"),
    table_caption("table-caption"),
    table_column_group("table-column-group"),
    table_header_group("table-header-group"),
    table_footer_group("table-footer-group"),
    table_row_group("table-row-group"),
    table_cell("table-cell"),
    table_column("table-column"),
    table_row("table-row"),
    ;

    override fun toString(): String = value ?: name
}
