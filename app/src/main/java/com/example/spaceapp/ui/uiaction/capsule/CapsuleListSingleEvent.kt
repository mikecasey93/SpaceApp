package com.example.spaceapp.ui.uiaction.capsule

import com.example.common.state.UiSingleEvent

sealed class CapsuleListSingleEvent: UiSingleEvent {
    data class GoToDetailsScreen(val route: String): CapsuleListSingleEvent()
}