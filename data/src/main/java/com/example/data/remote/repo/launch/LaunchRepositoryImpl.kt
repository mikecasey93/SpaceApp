package com.example.data.remote.repo.launch

import com.example.domain.entity.LaunchObj
import com.example.domain.repo.LaunchRepository
import kotlinx.coroutines.flow.Flow

class LaunchRepositoryImpl (
    private val remoteSource: RemoteLaunchDataSource
) : LaunchRepository {

    override fun getLaunches(): Flow<List<LaunchObj>> {
        return remoteSource.getLaunches()
    }

    override fun getLaunchItem(id: Int?): Flow<LaunchObj> {
        return remoteSource.getLaunch(id)
    }
}