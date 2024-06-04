package com.example.data.remote.source.rocket

import com.example.data.remote.endpoints.SpaceAppEndPoints
import com.example.data.remote.network.rocket.RocketItemModel
import com.example.data.remote.repo.rocket.RemoteRocketDataSource
import com.example.domain.entity.RocketObj
import com.example.domain.entity.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteRocketDataSourceImpl @Inject constructor(
    private val service: SpaceAppEndPoints
): RemoteRocketDataSource {

    override fun getRockets(): Flow<List<RocketObj>> = flow {
        val rockets = service.getRockets()
        emit(rockets)
    }.map { rocketList ->
        rocketList.map { rocket -> convert(rocket) }
    }.catch {
        throw UseCaseException.AppException(it)
    }

    override fun getRocket(id: Int?): Flow<RocketObj> = flow {
        emit(service.getRocket(id))
    }.map {
        convert(it)
    }.catch {
        throw UseCaseException.AppException(it)
    }

    private fun convert(model: RocketItemModel): RocketObj {
        return RocketObj(
            description = model.description,
            id = model.id,
            rocketName = model.rocketName,
            company = model.company,
            costPerLaunch = model.costPerLaunch
        )
    }
}