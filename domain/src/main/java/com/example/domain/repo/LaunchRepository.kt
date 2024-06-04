package com.example.domain.repo

import com.example.domain.entity.LaunchObj
import kotlinx.coroutines.flow.Flow

interface LaunchRepository {

    fun getLaunches(): Flow<List<LaunchObj>>

    fun getLaunchItem(id: Int?): Flow<LaunchObj>
}