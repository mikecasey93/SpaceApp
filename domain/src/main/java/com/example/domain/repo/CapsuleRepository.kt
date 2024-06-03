package com.example.domain.repo

import com.example.domain.entity.CapsuleObj
import kotlinx.coroutines.flow.Flow

interface CapsuleRepository {

    fun getCapsules(): Flow<List<CapsuleObj?>?>

    fun getCapsule(capsuleId: String?): Flow<CapsuleObj>
}