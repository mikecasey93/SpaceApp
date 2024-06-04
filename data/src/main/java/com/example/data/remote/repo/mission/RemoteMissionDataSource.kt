package com.example.data.remote.repo.mission

import com.example.domain.entity.MissionObj
import kotlinx.coroutines.flow.Flow

interface RemoteMissionDataSource {

    fun getMissions(): Flow<List<MissionObj>>

    fun getMission(id: String?): Flow<MissionObj>
}