package com.example.data.remote.repo.mission

import com.example.domain.entity.MissionObj
import com.example.domain.repo.MissionRepository
import kotlinx.coroutines.flow.Flow

class MissionRepositoryImpl (
    private val remoteSource: RemoteMissionDataSource
): MissionRepository {

    override fun getMissions(): Flow<List<MissionObj>> {
        return remoteSource.getMissions()
    }

    override fun getMission(id: String?): Flow<MissionObj> {
        return remoteSource.getMission(id)
    }

}