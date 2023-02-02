package org.geepawhill.html.css

enum class DisplayEnum(val value: String) {
    none("none"),
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
    initial("initial"),
    inherit("inherit"),
}

enum class BoxSizingEnum(val value: String) {
    content_box("content-box"),
    border_box("border-box"),
    initial("initial"),
    inherit("inherit")
}

enum class TextDecorationEnum(val value: String) {
    none("none"),
    overline("overline"),
    line_through("line-through"),
    underline("underline"),
    inherit("inherit"),

    ;

    operator fun plus(other: TextDecorationEnum): String {
        return this.value + " " + other.value
    }
}
