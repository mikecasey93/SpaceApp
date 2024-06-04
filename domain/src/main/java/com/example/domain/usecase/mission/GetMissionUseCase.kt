package com.example.domain.usecase.mission

import com.example.domain.entity.MissionObj
import com.example.domain.repo.MissionRepository
import com.example.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetMissionUseCase (
    configuration: Configuration,
    private val repo: MissionRepository
): UseCase<GetMissionUseCase.Request, GetMissionUseCase.Response>(configuration){
    override fun process(request: Request): Flow<Response> =
        repo.getMissions()
            .map {
                Response(it)
            }

    data object Request : UseCase.Request
    data class Response(val missions: List<MissionObj?>?) : UseCase.Response


}