package com.example.spaceapp.ui.uiaction.capsule

import com.example.common.state.UiAction

sealed class CapsuleListAction: UiAction {

    data object Loading : CapsuleListAction()
    data class CapsuleItemClick(
        val capsuleId: String?,
        val details: String?,
        val landings: Int?,
        val originalLaunch: String?,
        val status: String?
    ) : CapsuleListAction()

}