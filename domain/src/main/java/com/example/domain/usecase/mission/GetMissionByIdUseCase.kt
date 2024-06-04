package com.example.domain.usecase.mission

import com.example.domain.entity.LaunchObj
import com.example.domain.entity.MissionObj
import com.example.domain.repo.LaunchRepository
import com.example.domain.repo.MissionRepository
import com.example.domain.usecase.UseCase
import com.example.domain.usecase.launch.GetLaunchByIdUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetMissionByIdUseCase (
    configuration: Configuration,
    private val repo: MissionRepository
) : UseCase<GetMissionByIdUseCase.Request, GetMissionByIdUseCase.Response>(configuration) {
    override fun process(request: Request): Flow<Response> =
        repo.getMission(request.id)
            .map {
                Response(it)
            }

    data class Request(val id: String?) : UseCase.Request
    data class Response(val missionItem: MissionObj) : UseCase.Response


}