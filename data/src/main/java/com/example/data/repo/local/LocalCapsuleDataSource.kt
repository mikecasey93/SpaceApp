package com.example.data.repo.local


import com.example.domain.entity.CapsuleObj
import kotlinx.coroutines.flow.Flow


interface LocalCapsuleDataSource {

    fun getCapsules(): Flow<List<CapsuleObj>>

    fun getCapsule(capsuleId: String?): Flow<CapsuleObj>

    suspend fun addCapsule(capsules: List<CapsuleObj?>?)

}