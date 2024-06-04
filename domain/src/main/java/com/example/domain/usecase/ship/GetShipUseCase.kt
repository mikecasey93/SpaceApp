package com.example.domain.usecase.ship

import com.example.domain.entity.ShipObj
import com.example.domain.repo.ShipRepository
import com.example.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetShipUseCase(
    configuration: Configuration,
    private val repo: ShipRepository
) : UseCase<GetShipUseCase.Request, GetShipUseCase.Response>(configuration){


    override fun process(request: Request): Flow<Response> =
        repo.getShips()
            .map {
                Response(it)
            }


    data object Request : UseCase.Request
    data class Response(val ship: List<ShipObj>) : UseCase.Response
}