package com.example.domain.repo

import com.example.domain.entity.MissionObj
import kotlinx.coroutines.flow.Flow

interface MissionRepository {

    fun getMissions(): Flow<List<MissionObj>>

    fun getMission(id: String?): Flow<MissionObj>
}