package com.example.spaceapp.ui.uiaction.mission

import com.example.common.state.UiAction

sealed class MissionListAction: UiAction {

    data object Load: MissionListAction()

    data class OnMissionItemClick(
        val description: String?
    ): MissionListAction()
}