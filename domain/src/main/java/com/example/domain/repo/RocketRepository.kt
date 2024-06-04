package com.example.domain.repo

import com.example.domain.entity.RocketObj
import kotlinx.coroutines.flow.Flow

interface RocketRepository {

    fun getRockets(): Flow<List<RocketObj>>

    fun getRocket(id: Int?): Flow<RocketObj>
}