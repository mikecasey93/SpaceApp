package com.example.data.repo

import com.example.data.repo.local.LocalCapsuleDataSource
import com.example.data.repo.remote.RemoteCapsuleDataSource
import com.example.domain.entity.CapsuleObj
import com.example.domain.repo.CapsuleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

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