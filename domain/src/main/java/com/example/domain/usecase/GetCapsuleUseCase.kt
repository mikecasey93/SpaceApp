package com.example.domain.usecase

import com.example.domain.entity.CapsuleObj
import com.example.domain.repo.CapsuleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCapsuleUseCase(
    configuration: UseCase.Configuration,
    private val repo: CapsuleRepository
) : UseCase<GetCapsuleUseCase.Request, GetCapsuleUseCase.Response>(configuration){

    override fun process(request: Request): Flow<Response> =
        repo.getCapsules().map {
            Response(it)
        }

    data object Request : UseCase.Request

    data class Response(val capsules: List<CapsuleObj?>?) : UseCase.Response
}