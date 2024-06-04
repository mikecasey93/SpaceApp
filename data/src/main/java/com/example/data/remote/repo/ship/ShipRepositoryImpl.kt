package com.example.data.remote.repo.ship

import com.example.domain.entity.ShipObj
import com.example.domain.repo.ShipRepository
import kotlinx.coroutines.flow.Flow

class ShipRepositoryImpl (
    private val remoteSource: RemoteShipDataSource
) : ShipRepository {
    override fun getShips(): Flow<List<ShipObj>> {
        return remoteSource.getShips()
    }

    override fun getShip(id: String?): Flow<ShipObj> {
        return remoteSource.getShip(id)
    }
}