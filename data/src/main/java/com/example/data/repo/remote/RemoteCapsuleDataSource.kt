package com.example.data.repo.remote

import com.example.domain.entity.CapsuleObj
import kotlinx.coroutines.flow.Flow

interface RemoteCapsuleDataSource {

    fun getCapsules(): Flow<List<CapsuleObj?>?>

    fun getCapsule(capsuleId: String?): Flow<CapsuleObj>
}