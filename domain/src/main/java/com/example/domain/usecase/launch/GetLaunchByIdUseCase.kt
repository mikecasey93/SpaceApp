package com.example.domain.usecase.launch

import com.example.domain.entity.LaunchObj
import com.example.domain.repo.LaunchRepository
import com.example.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetLaunchByIdUseCase(
    configuration: UseCase.Configuration,
    private val repo: LaunchRepository
) : UseCase<GetLaunchByIdUseCase.Request, GetLaunchByIdUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        repo.getLaunchItem(request.id)
            .map {
                Response(it)
            }

    data class Request(val id: Int?) : UseCase.Request
    data class Response(val launchItem: LaunchObj) : UseCase.Response
}