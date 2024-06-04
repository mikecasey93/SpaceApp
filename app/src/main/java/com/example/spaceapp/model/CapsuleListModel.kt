package com.example.spaceapp.model


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
