package com.example.data.remote.repo.rocket

import com.example.domain.entity.RocketObj
import kotlinx.coroutines.flow.Flow

interface RemoteRocketDataSource {

    fun getRockets(): Flow<List<RocketObj>>

    fun getRocket(id: Int?): Flow<RocketObj>
}