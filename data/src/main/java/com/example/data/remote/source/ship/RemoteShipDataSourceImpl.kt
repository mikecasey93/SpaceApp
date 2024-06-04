package com.example.data.remote.source.ship

import com.example.data.remote.endpoints.SpaceAppEndPoints
import com.example.data.remote.network.ship.ShipItemModel
import com.example.data.remote.repo.ship.RemoteShipDataSource
import com.example.domain.entity.ShipObj
import com.example.domain.entity.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteShipDataSourceImpl @Inject constructor(
    private val service: SpaceAppEndPoints
) : RemoteShipDataSource {

    override fun getShips(): Flow<List<ShipObj>> = flow {
        val ships = service.getShips()
        emit(ships)
    }.map { shipList ->
        shipList.map { ship -> convert(ship) }
    }.catch {
        throw UseCaseException.AppException(it)
    }

    override fun getShip(id: String?): Flow<ShipObj> = flow {
        emit(service.getShip(id))
    }.map {
        convert(it)
    }.catch {
        throw UseCaseException.AppException(it)
    }

    private fun convert(model: ShipItemModel): ShipObj {
        return ShipObj(
            image = model.image,
            shipId = model.shipId,
            shipName = model.shipName,
            shipType = model.shipType,
            status = model.status,
            yearBuilt = model.yearBuilt,
            active = model.active
        )
    }
}