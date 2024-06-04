package com.example.spaceapp.ui.uiaction.rocket

import com.example.common.state.UiSingleEvent

sealed class RocketListSingleEvent: UiSingleEvent {


    data class OpenDetailsScreen(val navRoute: String): RocketListSingleEvent()
}