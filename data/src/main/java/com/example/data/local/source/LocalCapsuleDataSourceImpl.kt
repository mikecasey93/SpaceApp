package com.example.data.local.source

import com.example.data.local.db.capsule.CapsuleDao
import com.example.data.local.db.capsule.CapsuleEntity
import com.example.data.repo.local.LocalCapsuleDataSource
import com.example.domain.entity.CapsuleObj
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalCapsuleDataSourceImpl @Inject constructor(
    private val dao: CapsuleDao
) : LocalCapsuleDataSource {

    override fun getCapsules(): Flow<List<CapsuleObj>> =
        dao.getCapsules().map {
            it.map { capsule ->
                CapsuleObj(
                    capsuleId = capsule.capsuleId,
                    capsuleSerial = capsule.capsuleSerial,
                    details = capsule.details,
                    landings = capsule.landings,
                    missions = capsule.missions,
                    originalLaunch = capsule.originalLaunch,
                    originalLaunchUnix = capsule.originalLaunchUnix,
                    reuseCount = capsule.reuseCount,
                    status = capsule.status,
                    type = capsule.type
                )
            }
        }

    override fun getCapsule(capsuleId: String?): Flow<CapsuleObj> =
        dao.getCapsule(capsuleId).map {
            CapsuleObj(
                it.capsuleId,
                it.capsuleSerial,
                it.details,
                it.landings,
                it.missions,
                it.originalLaunch,
                it.originalLaunchUnix,
                it.reuseCount,
                it.status,
                it.type
            )
        }

    override suspend fun addCapsule(capsules: List<CapsuleObj?>?) =
        dao.insertCapsule(capsules!!.map { capsule ->
            CapsuleEntity(
                capsuleId = capsule?.capsuleId,
                capsuleSerial = capsule?.capsuleSerial,
                details = capsule?.details,
                landings = capsule?.landings,
                missions = capsule?.missions,
                originalLaunch = capsule?.originalLaunch,
                originalLaunchUnix = capsule?.originalLaunchUnix,
                reuseCount = capsule?.reuseCount,
                status = capsule?.status,
                type = capsule?.type
            )
        })
}