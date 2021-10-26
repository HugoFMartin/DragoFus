package com.hugofmartin.dragofus.ui.initialize_screen.fragment.initialize_setup

sealed class InitializeSetupUiEvent {
    data class ShowToast(val message: String): InitializeSetupUiEvent()
    object SaveAchievement: InitializeSetupUiEvent()
}
