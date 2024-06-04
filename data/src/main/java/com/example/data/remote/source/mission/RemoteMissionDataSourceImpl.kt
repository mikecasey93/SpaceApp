package com.example.data.remote.source.mission

import com.example.data.remote.endpoints.SpaceAppEndPoints
import com.example.data.remote.network.mission.MissionItemModel
import com.example.data.remote.repo.mission.RemoteMissionDataSource
import com.example.domain.entity.MissionObj
import com.example.domain.entity.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteMissionDataSourceImpl @Inject constructor(
    private val service: SpaceAppEndPoints
): RemoteMissionDataSource {

    override fun getMissions(): Flow<List<MissionObj>> = flow {
        val missions = service.getMissions()
        emit(missions)
    }.map { missionList ->
        missionList.map { mission -> convert(mission) }
    }.catch {
        throw UseCaseException.AppException(it)
    }

    override fun getMission(id: String?): Flow<MissionObj> = flow {
        emit(service.getMission(id))
    }.map {
        convert(it)
    }.catch {
        throw UseCaseException.AppException(it)
    }

    private fun convert(model: MissionItemModel): MissionObj {
        return MissionObj(
            description = model.description,
            missionId = model.missionId,
            missionName = model.missionName,
        )
    }
}