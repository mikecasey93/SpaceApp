package com.example.data.remote.repo.ship

import com.example.domain.entity.ShipObj
import kotlinx.coroutines.flow.Flow

interface RemoteShipDataSource {

    fun getShips(): Flow<List<ShipObj>>

    fun getShip(id: String?): Flow<ShipObj>
}