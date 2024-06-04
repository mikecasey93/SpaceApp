package com.example.data.remote.source.launch

import com.example.data.remote.endpoints.SpaceAppEndPoints
import com.example.data.remote.network.launch.LaunchItemModel
import com.example.data.remote.repo.launch.RemoteLaunchDataSource
import com.example.domain.entity.LaunchObj
import com.example.domain.entity.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteLaunchDataSourceImpl @Inject constructor(
    private val service: SpaceAppEndPoints
): RemoteLaunchDataSource {

    override fun getLaunches(): Flow<List<LaunchObj>> = flow {
        val launches = service.getLaunches()
        emit(launches)
    }.map { launchList ->
        launchList.map { launch -> convert(launch) }
    }.catch {
        throw UseCaseException.AppException(it)
    }

    override fun getLaunch(id: Int?): Flow<LaunchObj> = flow {
        emit(service.getLaunch(id))
    }.map {
        convert(it)
    }.catch {
        throw UseCaseException.AppException(it)
    }

    private fun convert(model: LaunchItemModel): LaunchObj {
        return LaunchObj(
            details = model.details,
            flightNumber = model.flightNumber,
            launchSuccess = model.launchSuccess,
            launchYear = model.launchYear,
            missionName = model.missionName
        )
    }
}