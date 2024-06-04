package com.example.data.remote.repo.rocket

import com.example.data.remote.repo.rocket.RemoteRocketDataSource
import com.example.domain.entity.RocketObj
import com.example.domain.repo.RocketRepository
import kotlinx.coroutines.flow.Flow

class RocketRepositoryImpl (
    private val remoteSource: RemoteRocketDataSource
) : RocketRepository {
    override fun getRockets(): Flow<List<RocketObj>> {
        return remoteSource.getRockets()
    }

    override fun getRocket(id: Int?): Flow<RocketObj> {
        return remoteSource.getRocket(id)
    }
}