package com.hugofmartin.dragofus.ui.initialize_screen.fragment.initialize_setup

sealed class InitializeSetupEvent {
    data class EnteredNbCoupling(val value: String): InitializeSetupEvent()
    data class EnteredNbBirth(val value: String): InitializeSetupEvent()
    object ValidateAchievement: InitializeSetupEvent()
}
