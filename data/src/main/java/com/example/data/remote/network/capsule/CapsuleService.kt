package com.example.data.remote.network.capsule

import com.example.data.local.db.capsule.CapsuleApiDetail
import retrofit2.http.GET

interface CapsuleService {

    @GET(CapsuleApiDetail.CAPSULE_ENDPOINT)
    suspend fun getCapsule() : Capsule

    @GET(CapsuleApiDetail.CAPSULE_ENDPOINT)
    suspend fun getCapsuleModel(capsuleId: String?) : CapsuleItemModel
}