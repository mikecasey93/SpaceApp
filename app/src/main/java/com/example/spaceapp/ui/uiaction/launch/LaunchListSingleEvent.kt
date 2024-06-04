package com.example.spaceapp.ui.uiaction.launch

import com.example.common.state.UiSingleEvent

sealed class LaunchListSingleEvent: UiSingleEvent {

    data class OpenDetailsScreen(val navRoute: String): LaunchListSingleEvent()
}