package com.example.domain.usecase.capsule

import com.example.domain.entity.CapsuleObj
import com.example.domain.repo.CapsuleRepository
import com.example.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCapsuleByIdUseCase(
    configuration: Configuration,
    private val repo: CapsuleRepository
) : UseCase<GetCapsuleByIdUseCase.Request, GetCapsuleByIdUseCase.Response>(configuration) {


    override fun process(request: Request): Flow<Response> =
        repo.getCapsule(request.capsuleId).map {
            Response(it)
        }

    data class Request(val capsuleId: String?) : UseCase.Request

    data class Response(val capsule: CapsuleObj?) : UseCase.Response
}