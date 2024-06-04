package com.example.data.remote.repo.launch

import com.example.domain.entity.LaunchObj
import kotlinx.coroutines.flow.Flow

interface RemoteLaunchDataSource {

    fun getLaunches(): Flow<List<LaunchObj>>

    fun getLaunch(id: Int?): Flow<LaunchObj>
}