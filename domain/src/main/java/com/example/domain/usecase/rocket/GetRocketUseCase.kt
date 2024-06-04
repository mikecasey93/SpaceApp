package com.example.domain.usecase.rocket

import com.example.domain.entity.RocketObj
import com.example.domain.repo.RocketRepository
import com.example.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetRocketUseCase (
    configuration: Configuration,
    private val repo: RocketRepository
) : UseCase<GetRocketUseCase.Request, GetRocketUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        repo.getRockets()
            .map {
                Response(it)
            }


    data object Request : UseCase.Request
    data class Response(val rockets: List<RocketObj?>?) : UseCase.Response
}