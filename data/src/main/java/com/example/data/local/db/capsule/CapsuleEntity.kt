package com.example.data.local.db.capsule

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.remote.network.capsule.MissionModel

@Entity(tableName = "capsule")
data class CapsuleEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "capsule_id") val capsuleId: String? = "",
    @ColumnInfo(name = "capsule_serial") val capsuleSerial: String? = "",
    @ColumnInfo(name = "details") val details: String? = "",
    @ColumnInfo(name = "landings") val landings: Int? = 0,
    @ColumnInfo(name = "missions") val missions: List<MissionModel?>? = listOf(),
    @ColumnInfo(name = "original_launch") val originalLaunch: String? = "",
    @ColumnInfo(name = "original_launch_unix") val originalLaunchUnix: Int? = 0,
    @ColumnInfo(name = "reuse_count") val reuseCount: Int? = 0,
    @ColumnInfo(name = "status") val status: String? = "",
    @ColumnInfo(name = "type") val type: String? = "",
)
