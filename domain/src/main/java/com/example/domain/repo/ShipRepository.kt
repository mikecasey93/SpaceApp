package com.example.domain.repo

import com.example.domain.entity.ShipObj
import kotlinx.coroutines.flow.Flow

interface ShipRepository {

    fun getShips(): Flow<List<ShipObj>>

    fun getShip(id: String?): Flow<ShipObj>
}