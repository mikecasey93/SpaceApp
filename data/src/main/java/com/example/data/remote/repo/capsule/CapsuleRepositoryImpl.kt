package com.example.data.remote.repo.capsule

import com.example.domain.entity.CapsuleObj
import com.example.domain.repo.CapsuleRepository
import kotlinx.coroutines.flow.Flow

class CapsuleRepositoryImpl(
    private val remoteSource: RemoteCapsuleDataSource,
) : CapsuleRepository {

    override fun getCapsules(): Flow<List<CapsuleObj?>?> {
        return remoteSource.getCapsules()
    }
    override fun getCapsule(capsuleId: String?): Flow<CapsuleObj> {
        return remoteSource.getCapsule(capsuleId)
    }
}