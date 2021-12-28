package com.hugofmartin.dragofus.ui.main_screen.list_dragodinde

sealed class ListDragodindeEventUI {
    object ToggleFilter:ListDragodindeEventUI()
    object UpdateDragodindeList:ListDragodindeEventUI()
}
