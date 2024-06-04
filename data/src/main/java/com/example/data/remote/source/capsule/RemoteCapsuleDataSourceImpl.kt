package com.example.data.remote.source.capsule

import com.example.data.remote.endpoints.SpaceAppEndPoints
import com.example.data.remote.network.capsule.CapsuleItemModel
import com.example.data.remote.repo.capsule.RemoteCapsuleDataSource
import com.example.domain.entity.CapsuleObj
import com.example.domain.entity.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteCapsuleDataSourceImpl @Inject constructor(
    private val service: SpaceAppEndPoints
) : RemoteCapsuleDataSource {

    override fun getCapsules(): Flow<List<CapsuleObj?>?> = flow {
        val capsules = service.getCapsules()
        emit(capsules)
    }.map { model ->
        model.map { apiModel ->
            convert(apiModel)
        }
    }.catch {
        throw UseCaseException.AppException(it)
    }

    override fun getCapsule(capsuleId: String?): Flow<CapsuleObj> = flow {
        emit(service.getCapsule(capsuleId))
    }.map {
        convert(it)
    }.catch {
        throw UseCaseException.AppException(it)
    }

    private fun convert(model: CapsuleItemModel?) =
        CapsuleObj(
            model?.capsuleId,
            model?.capsuleSerial,
            model?.details,
            model?.landings,
            model?.originalLaunch,
            model?.originalLaunchUnix,
            model?.reuseCount,
            model?.status,
            model?.type
        )
}