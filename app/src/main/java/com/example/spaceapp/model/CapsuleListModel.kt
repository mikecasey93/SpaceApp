package com.example.spaceapp.model

import android.telecom.Call.Details
import com.example.common.nav.NavRoutes


data class CapsuleListModel(
    val capsules: List<Capsule> = listOf()
)

data class Capsule(
    val capsuleId: String? = "",
    val details: String? = "",
    val landings: Int? = 0,
    val originalLaunch: String?,
    val status: String? = ""
)
