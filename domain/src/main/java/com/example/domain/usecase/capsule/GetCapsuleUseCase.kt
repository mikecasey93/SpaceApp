package com.example.domain.usecase.capsule

import com.example.domain.entity.CapsuleObj
import com.example.domain.repo.CapsuleRepository
import com.example.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCapsuleUseCase(
    configuration: Configuration,
    private val repo: CapsuleRepository
) : UseCase<GetCapsuleUseCase.Request, GetCapsuleUseCase.Response>(configuration){

    override fun process(request: Request): Flow<Response> =
        repo.getCapsules().map {
            Response(it)
        }

    data object Request : UseCase.Request

    data class Response(val capsules: List<CapsuleObj?>?) : UseCase.Response
}