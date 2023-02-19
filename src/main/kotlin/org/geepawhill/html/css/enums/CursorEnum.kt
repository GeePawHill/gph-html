package org.geepawhill.html.css.enums

enum class CursorEnum(val realName: String? = null) {
    alias,
    all_scroll("all-scroll"),
    cell,
    col_resize("col-resize"),
    context_menu("context-menu"),
    copy,
    crosshair,
    default,
    e_resize("e-resize"),
    ew_resize("ew-resize"),
    grab,
    grabbing,
    help,
    move,
    n_resize("n-resize"),
    ne_resize("ne-resize"),
    nwse_resize("nwse-resize"),
    no_drop("no-drop"),
    not_allowed("not-allowed"),
    pointer,
    progress,
    row_resize("row-resize"),
    s_resize("s-resize"),
    se_resize("se-resize"),
    sw_resize("sw-resize"),
    text,
    URL,
    vertical_text("vertical-text"),
    w_resize("w-resize"),
    wait,
    zoom_in("zoom-in"),
    zoom_out("zoom-out")
    ;

    override fun toString(): String = realName ?: name
}
