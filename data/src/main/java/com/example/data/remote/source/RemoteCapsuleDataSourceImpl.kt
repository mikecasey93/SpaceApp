package com.example.data.remote.source

import com.example.data.remote.network.capsule.CapsuleItemModel
import com.example.data.remote.network.capsule.CapsuleService
import com.example.data.repo.remote.RemoteCapsuleDataSource
import com.example.domain.entity.CapsuleObj
import com.example.domain.entity.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteCapsuleDataSourceImpl @Inject constructor(
    private val service: CapsuleService
) : RemoteCapsuleDataSource {

    override fun getCapsules(): Flow<List<CapsuleObj?>?> = flow {
        emit(service.getCapsule())
    }.map { model ->
        model.map { apiModel ->
            convert(apiModel)
        }
    }.catch {
        throw UseCaseException.CapsuleException(it)
    }

    override fun getCapsule(capsule: String?): Flow<CapsuleObj> = flow {
        emit(service.getCapsuleModel(capsule))
    }.map {
        convert(it)
    }.catch {
        throw UseCaseException.CapsuleException(it)
    }

    private fun convert(model: CapsuleItemModel?) =
        CapsuleObj(
            model?.capsuleId,
            model?.capsuleSerial,
            model?.details,
            model?.landings,
            model?.missions,
            model?.originalLaunch,
            model?.originalLaunchUnix,
            model?.reuseCount,
            model?.status,
            model?.type
        )
}