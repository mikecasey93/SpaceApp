package com.example.spaceapp.ui.uiaction.mission

import com.example.common.state.UiSingleEvent

sealed class MissionListSingleEvent: UiSingleEvent {

    data class OpenDetailsScreen(val navRoute: String): MissionListSingleEvent()
}