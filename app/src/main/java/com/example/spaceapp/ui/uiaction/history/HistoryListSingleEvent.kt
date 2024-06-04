package com.example.spaceapp.ui.uiaction.history

import com.example.common.state.UiSingleEvent

sealed class HistoryListSingleEvent: UiSingleEvent {

    data class OpenDetailsScreen(val navRoute: String): HistoryListSingleEvent()
}