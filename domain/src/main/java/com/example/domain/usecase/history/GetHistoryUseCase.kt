package com.example.domain.usecase.history

import com.example.domain.entity.HistoryObj
import com.example.domain.repo.HistoryRepository
import com.example.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetHistoryUseCase(
    configuration: UseCase.Configuration,
    private val repo: HistoryRepository
): UseCase<GetHistoryUseCase.Request, GetHistoryUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        repo.getHistory()
            .map {
                Response(it)
            }

    data object Request : UseCase.Request
    data class Response(val history: List<HistoryObj?>?) : UseCase.Response
}