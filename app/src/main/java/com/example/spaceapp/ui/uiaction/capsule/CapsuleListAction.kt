package com.example.spaceapp.ui.uiaction.capsule

import com.example.common.state.UiAction

sealed class CapsuleListAction: com.example.common.state.UiAction {

    data object Load : CapsuleListAction()
    data class CapsuleItemClick(
        val capsuleId: String?,
        val details: String?,
        val landings: Int?,
        val originalLaunch: String?,
        val status: String?
    ) : CapsuleListAction()

}