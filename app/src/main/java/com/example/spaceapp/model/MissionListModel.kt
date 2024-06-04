package com.example.spaceapp.model

data class MissionListModel (
    val items: List<Mission>
)


data class Mission(
    val description: String? = "",
    val missionId: String? = "",
    val missionName: String? = "",
)